using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Tidsplan.Models;

namespace Tidsplan.Controllers
{
    public class WorkingDaysController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: WorkingDays
        public ActionResult Index()
        {
            return View(db.WorkingDays.OrderBy(w => w.name).ToList());
        }

        // GET: WorkingDays/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            WorkingDay workingDay = db.WorkingDays.Find(id);
            if (workingDay == null)
            {
                return HttpNotFound();
            }
            return View(workingDay);
        }

        // GET: WorkingDays/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: WorkingDays/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "workingDayID,initials,name,description,toUpper,toUpper2,toUpper3")] WorkingDay workingDay)
        {
            if (ModelState.IsValid)
            {
                db.WorkingDays.Add(workingDay);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception e)
                {
                    if (e.InnerException != null &&
                        e.InnerException.InnerException != null &&
                        e.InnerException.InnerException.Message.Contains("Index"))
                    {
                        ModelState.AddModelError(string.Empty, "El campo que intenta crear ya existe.");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, e.Message);
                    }
                    return View(workingDay);
                }
                return RedirectToAction("Index");
            }

            return View(workingDay);
        }

        // GET: WorkingDays/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            WorkingDay workingDay = db.WorkingDays.Find(id);
            if (workingDay == null)
            {
                return HttpNotFound();
            }
            return View(workingDay);
        }

        // POST: WorkingDays/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "workingDayID,initials,name,description,toUpper,toUpper2,toUpper3")] WorkingDay workingDay)
        {
            if (ModelState.IsValid)
            {
                db.Entry(workingDay).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(workingDay);
        }

        // GET: WorkingDays/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            WorkingDay workingDay = db.WorkingDays.Find(id);
            if (workingDay == null)
            {
                return HttpNotFound();
            }
            return View(workingDay);
        }

        // POST: WorkingDays/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            WorkingDay workingDay = db.WorkingDays.Find(id);
            db.WorkingDays.Remove(workingDay);
            try
            {
                db.SaveChanges();
            }
            catch (Exception e)
            {
                if (e.InnerException != null && 
                    e.InnerException.InnerException != null && 
                    e.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "El campo que intenta borrar ya está vinculado en otro registro.");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, e.Message);
                }
                return View(workingDay);
            }
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
