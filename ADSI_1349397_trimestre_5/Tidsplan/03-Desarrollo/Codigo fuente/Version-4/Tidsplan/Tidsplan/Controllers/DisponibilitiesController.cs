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
    public class DisponibilitiesController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Disponibilities
        public ActionResult Index()
        {
            var disponibilities = db.Disponibilities.Include(d => d.Instructor);
            return View(disponibilities.OrderBy(d=> d.Instructor.documentNumber).ToList());
        }

        // GET: Disponibilities/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Disponibility disponibility = db.Disponibilities.Find(id);
            if (disponibility == null)
            {
                return HttpNotFound();
            }
            return View(disponibility);
        }

        // GET: Disponibilities/Create
        [Authorize]
        public ActionResult Create()
        {
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber");
            return View();
        }

        // POST: Disponibilities/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idDisponibility,startHour,endHour,lunes,martes,miercoles,jueves,viernes,sabado,domingo,instructorID")] Disponibility disponibility)
        {
            if (ModelState.IsValid)
            {
                db.Disponibilities.Add(disponibility);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber", disponibility.instructorID);
            return View(disponibility);
        }

        // GET: Disponibilities/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Disponibility disponibility = db.Disponibilities.Find(id);
            if (disponibility == null)
            {
                return HttpNotFound();
            }
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber", disponibility.instructorID);
            return View(disponibility);
        }

        // POST: Disponibilities/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idDisponibility,startHour,endHour,lunes,martes,miercoles,jueves,viernes,sabado,domingo,instructorID")] Disponibility disponibility)
        {
            if (ModelState.IsValid)
            {
                db.Entry(disponibility).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber", disponibility.instructorID);
            return View(disponibility);
        }

        // GET: Disponibilities/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Disponibility disponibility = db.Disponibilities.Find(id);
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
            Disponibility disponibility = db.Disponibilities.Find(id);
            db.Disponibilities.Remove(disponibility);
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
