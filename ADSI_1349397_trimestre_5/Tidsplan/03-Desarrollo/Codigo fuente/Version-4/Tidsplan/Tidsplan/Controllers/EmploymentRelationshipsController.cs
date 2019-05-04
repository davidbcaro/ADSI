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
    public class EmploymentRelationshipsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: EmploymentRelationships
        public ActionResult Index()
        {
            return View(db.EmploymentRelationships.OrderBy(ep=> ep.typeEmploymentRelationship).ToList());
        }

        // GET: EmploymentRelationships/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            EmploymentRelationship employmentRelationship = db.EmploymentRelationships.Find(id);
            if (employmentRelationship == null)
            {
                return HttpNotFound();
            }
            return View(employmentRelationship);
        }

        // GET: EmploymentRelationships/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmploymentRelationships/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idEmploymentRelationship,typeEmploymentRelationship,toUpper,hours")] EmploymentRelationship employmentRelationship)
        {
            if (ModelState.IsValid)
            {
                db.EmploymentRelationships.Add(employmentRelationship);
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
                    return View(employmentRelationship);
                }
                return RedirectToAction("Index");
            }

            return View(employmentRelationship);
        }

        // GET: EmploymentRelationships/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            EmploymentRelationship employmentRelationship = db.EmploymentRelationships.Find(id);
            if (employmentRelationship == null)
            {
                return HttpNotFound();
            }
            return View(employmentRelationship);
        }

        // POST: EmploymentRelationships/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idEmploymentRelationship,typeEmploymentRelationship,toUpper,hours")] EmploymentRelationship employmentRelationship)
        {
            if (ModelState.IsValid)
            {
                db.Entry(employmentRelationship).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(employmentRelationship);
        }

        // GET: EmploymentRelationships/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            EmploymentRelationship employmentRelationship = db.EmploymentRelationships.Find(id);
            if (employmentRelationship == null)
            {
                return HttpNotFound();
            }
            return View(employmentRelationship);
        }

        // POST: EmploymentRelationships/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            EmploymentRelationship employmentRelationship = db.EmploymentRelationships.Find(id);
            db.EmploymentRelationships.Remove(employmentRelationship);
           try
            {
                db.SaveChanges();
            }
            catch (Exception e)
            {
                if(e.InnerException!= null && 
                   e.InnerException.InnerException != null && 
                   e.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "El campo que intenta borrar ya está vinculado en otro registro");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, e.Message);
                }
                return View(employmentRelationship);
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
