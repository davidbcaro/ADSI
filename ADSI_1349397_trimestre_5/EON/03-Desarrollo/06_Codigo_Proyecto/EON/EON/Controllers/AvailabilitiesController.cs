using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using EON.Models;

namespace EON.Controllers
{
    public class AvailabilitiesController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Availabilities
        public ActionResult Index()
        {
            var availabilities = db.Availabilities.Include(a => a.workingDay);
            return View(db.Availabilities.OrderBy(a => a.Start_Time).ToList());
        }

        // GET: Availabilities/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Availability availability = db.Availabilities.Find(id);
            if (availability == null)
            {
                return HttpNotFound();
            }
            return View(availability);
        }

        // GET: Availabilities/Create
        public ActionResult Create()
        {
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day");
            return View();
        }

        // POST: Availabilities/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idAvailability,Start_Time,End_Time,id_working_Day,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday")] Availability availability)
        {
            if (ModelState.IsValid)
            {
                db.Availabilities.Add(availability);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day", availability.id_working_Day);
            return View(availability);
        }

        // GET: Availabilities/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Availability availability = db.Availabilities.Find(id);
            if (availability == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day", availability.id_working_Day);
            return View(availability);
        }

        // POST: Availabilities/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idAvailability,Start_Time,End_Time,id_working_Day,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday")] Availability availability)
        {
            if (ModelState.IsValid)
            {
                db.Entry(availability).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day", availability.id_working_Day);
            return View(availability);
        }

        // GET: Availabilities/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Availability availability = db.Availabilities.Find(id);
            if (availability == null)
            {
                return HttpNotFound();
            }
            return View(availability);
        }

        // POST: Availabilities/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Availability availability = db.Availabilities.Find(id);
            db.Availabilities.Remove(availability);
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
