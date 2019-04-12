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
    public class TrimestersController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Trimesters
        public ActionResult Index()
        {
            var trimesters = db.Trimesters.Include(t => t.Speciality).Include(t => t.workingDay);
            return View(trimesters.OrderBy(t => t.quarter_Name).ToList());
        }

        // GET: Trimesters/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Trimester trimester = db.Trimesters.Find(id);
            if (trimester == null)
            {
                return HttpNotFound();
            }
            return View(trimester);
        }

        // GET: Trimesters/Create
        public ActionResult Create()
        {
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name");
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day");
            return View();
        }

        // POST: Trimesters/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Trimester,quarter_Name,id_Speciality,id_working_Day")] Trimester trimester)
        {
            if (ModelState.IsValid)
            {
                db.Trimesters.Add(trimester);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name", trimester.id_Speciality);
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day", trimester.id_working_Day);
            return View(trimester);
        }

        // GET: Trimesters/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Trimester trimester = db.Trimesters.Find(id);
            if (trimester == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name", trimester.id_Speciality);
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day", trimester.id_working_Day);
            return View(trimester);
        }

        // POST: Trimesters/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Trimester,quarter_Name,id_Speciality,id_working_Day")] Trimester trimester)
        {
            if (ModelState.IsValid)
            {
                db.Entry(trimester).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name", trimester.id_Speciality);
            ViewBag.id_working_Day = new SelectList(db.workingDays, "id_working_Day", "acronyms_Working_day", trimester.id_working_Day);
            return View(trimester);
        }

        // GET: Trimesters/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Trimester trimester = db.Trimesters.Find(id);
            if (trimester == null)
            {
                return HttpNotFound();
            }
            return View(trimester);
        }

        // POST: Trimesters/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Trimester trimester = db.Trimesters.Find(id);
            db.Trimesters.Remove(trimester);
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
