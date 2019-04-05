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
    public class DisponibilitiesController : Controller
    {
        private DatabaseContext db = new DatabaseContext();

        // GET: Disponibilities
        public ActionResult Index()
        {
            var disponibilities = db.disponibilities.Include(d => d.WorkingDays);
            return View(disponibilities.ToList());
        }

        // GET: Disponibilities/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Disponibility disponibility = db.disponibilities.Find(id);
            if (disponibility == null)
            {
                return HttpNotFound();
            }
            return View(disponibility);
        }

        // GET: Disponibilities/Create
        public ActionResult Create()
        {
            ViewBag.IDinitials = new SelectList(db.WorkingDays, "IDinitials", "initials");
            return View();
        }

        // POST: Disponibilities/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IDDisponibility,typeDis,startDate,EndDate,IDinitials")] Disponibility disponibility)
        {
            if (ModelState.IsValid)
            {
                db.disponibilities.Add(disponibility);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IDinitials = new SelectList(db.WorkingDays, "IDinitials", "initials", disponibility.IDinitials);
            return View(disponibility);
        }

        // GET: Disponibilities/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Disponibility disponibility = db.disponibilities.Find(id);
            if (disponibility == null)
            {
                return HttpNotFound();
            }
            ViewBag.IDinitials = new SelectList(db.WorkingDays, "IDinitials", "initials", disponibility.IDinitials);
            return View(disponibility);
        }

        // POST: Disponibilities/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IDDisponibility,typeDis,startDate,EndDate,IDinitials")] Disponibility disponibility)
        {
            if (ModelState.IsValid)
            {
                db.Entry(disponibility).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IDinitials = new SelectList(db.WorkingDays, "IDinitials", "initials", disponibility.IDinitials);
            return View(disponibility);
        }

        // GET: Disponibilities/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Disponibility disponibility = db.disponibilities.Find(id);
            if (disponibility == null)
            {
                return HttpNotFound();
            }
            return View(disponibility);
        }

        // POST: Disponibilities/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Disponibility disponibility = db.disponibilities.Find(id);
            db.disponibilities.Remove(disponibility);
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
