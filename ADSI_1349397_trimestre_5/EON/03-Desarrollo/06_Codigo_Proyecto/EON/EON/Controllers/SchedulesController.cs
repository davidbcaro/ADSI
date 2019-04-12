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
    public class SchedulesController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Schedules
        public ActionResult Index(string SearchString , string sortOrder)
        {

            var schedules = db.Schedules.Include(s => s.ambience).Include(s => s.ficha).Include(s => s.instructor).Include(s => s.modality).Include(s => s.trimester).Include(s => s.version);

            if (!String.IsNullOrEmpty(SearchString))
            {

                schedules = schedules.Where(s => s.instructor.numberDocument.Contains(SearchString)
                || s.version.version_Name.Contains(SearchString)

                || s.modality.modality_Name.Contains(SearchString)

                || s.ambience.number_Ambience.Contains(SearchString)

                );

            }

            return View(schedules.OrderBy(s => s.end_Date).ToList());
        }

        // GET: Schedules/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Schedule schedule = db.Schedules.Find(id);
            if (schedule == null)
            {
                return HttpNotFound();
            }
            return View(schedule);
        }

        // GET: Schedules/Create
        public ActionResult Create()
        {
            var list = db.Ambiences.ToList();
            list = list.OrderBy(a => a.FullAmbience).ToList();
            ViewBag.id_Ambience = new SelectList(db.Ambiences, "id_Ambience", "FullAmbience");

            var list1 = db.Instructors.ToList();
            list1 = list1.OrderBy(i => i.FullInstructor).ToList();
            ViewBag.idInstructor = new SelectList(db.Instructors, "idInstructor", "FullInstructor");

            ViewBag.id_Modality = new SelectList(db.Modalities, "id_Modality", "modality_Name");

            var list2 = db.Versions.ToList();
            list2 = list2.OrderBy(v => v.FullVersion).ToList();
            ViewBag.id_Version = new SelectList(db.Versions, "id_Version", "FullVersion");
            

            ViewBag.id_Ficha = new SelectList(db.Fichas, "id_Ficha", "number_Ficha");

            ViewBag.id_Trimester = new SelectList(db.Trimesters, "id_Trimester", "quarter_Name");

            return View();
        }

        // POST: Schedules/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Schedule,start_Date,end_Date,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,id_Ambience,id_Modality,id_Version,idInstructor,id_Trimester,id_Ficha")] Schedule schedule)
        {
            if (ModelState.IsValid)
            {
                db.Schedules.Add(schedule);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Ambience = new SelectList(db.Ambiences, "id_Ambience", "number_Ambience", schedule.id_Ambience);
            ViewBag.id_Ficha = new SelectList(db.Fichas, "id_Ficha", "number_Ficha", schedule.id_Ficha);
            ViewBag.idInstructor = new SelectList(db.Instructors, "idInstructor", "numberDocument", schedule.idInstructor);
            ViewBag.id_Modality = new SelectList(db.Modalities, "id_Modality", "modality_Name", schedule.id_Modality);
            ViewBag.id_Trimester = new SelectList(db.Trimesters, "id_Trimester", "quarter_Name", schedule.id_Trimester);
            ViewBag.id_Version = new SelectList(db.Versions, "id_Version", "version_Name", schedule.id_Version);
            return View(schedule);
        }

        // GET: Schedules/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Schedule schedule = db.Schedules.Find(id);
            if (schedule == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_Ambience = new SelectList(db.Ambiences, "id_Ambience", "number_Ambience", schedule.id_Ambience);
            ViewBag.id_Ficha = new SelectList(db.Fichas, "id_Ficha", "number_Ficha", schedule.id_Ficha);
            ViewBag.idInstructor = new SelectList(db.Instructors, "idInstructor", "numberDocument", schedule.idInstructor);
            ViewBag.id_Modality = new SelectList(db.Modalities, "id_Modality", "modality_Name", schedule.id_Modality);
            ViewBag.id_Trimester = new SelectList(db.Trimesters, "id_Trimester", "quarter_Name", schedule.id_Trimester);
            ViewBag.id_Version = new SelectList(db.Versions, "id_Version", "version_Name", schedule.id_Version);
            return View(schedule);
        }

        // POST: Schedules/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Schedule,start_Date,end_Date,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,id_Ambience,id_Modality,id_Version,idInstructor,id_Trimester,id_Ficha")] Schedule schedule)
        {
            if (ModelState.IsValid)
            {
                db.Entry(schedule).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Ambience = new SelectList(db.Ambiences, "id_Ambience", "number_Ambience", schedule.id_Ambience);
            ViewBag.id_Ficha = new SelectList(db.Fichas, "id_Ficha", "number_Ficha", schedule.id_Ficha);
            ViewBag.idInstructor = new SelectList(db.Instructors, "idInstructor", "numberDocument", schedule.idInstructor);
            ViewBag.id_Modality = new SelectList(db.Modalities, "id_Modality", "modality_Name", schedule.id_Modality);
            ViewBag.id_Trimester = new SelectList(db.Trimesters, "id_Trimester", "quarter_Name", schedule.id_Trimester);
            ViewBag.id_Version = new SelectList(db.Versions, "id_Version", "version_Name", schedule.id_Version);
            return View(schedule);
        }

        // GET: Schedules/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Schedule schedule = db.Schedules.Find(id);
            if (schedule == null)
            {
                return HttpNotFound();
            }
            return View(schedule);
        }

        // POST: Schedules/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Schedule schedule = db.Schedules.Find(id);
            db.Schedules.Remove(schedule);
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
