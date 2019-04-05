using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using ChronoOfTime.Models;

namespace ChronoOfTime.Controllers
{
    public class WorkingDaysController : Controller
    {
        private DatabaseContext db = new DatabaseContext();

        // GET: WorkingDays
        public ActionResult Index()
        {
            return View(db.WorkingDays.ToList());
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
        public ActionResult Create()
        {
            return View();
        }

        // POST: WorkingDays/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IDinitials,initials,name,description,photo")] WorkingDay workingDay)
        {
            if (ModelState.IsValid)
            {
                db.WorkingDays.Add(workingDay);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(workingDay);
        }

        // GET: WorkingDays/Edit/5
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
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IDinitials,initials,name,description,photo")] WorkingDay workingDay)
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
            db.SaveChanges();
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
