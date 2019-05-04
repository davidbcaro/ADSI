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
    public class SchedulesController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Schedules
        public ActionResult Index(String searchString)
        {
            var schedules = db.Schedules.Include(s => s.environmentt).Include(s => s.group).Include(s => s.headquartes).Include(s => s.instructor).Include(s => s.trimester).Include(s => s.workingDay);
            if (!String.IsNullOrEmpty(searchString))
            {
                if (!String.IsNullOrEmpty(searchString))
                {
                    schedules = schedules.Where(s => s.instructor.documentNumber.Contains(searchString)
                                                   || s.group.numberGroup.Contains(searchString));


                }
            }
            return View(schedules.OrderBy(sc => sc.group.numberGroup).ToList());
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
        [Authorize]
        public ActionResult Create()
        {
            ViewBag.EnvironID = new SelectList(db.Environments, "EnvironID", "numberEnvironment");
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup");
            ViewBag.headquartesID = new SelectList(db.Headquartes, "headquartesID", "nameHeadquartes");
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "fullName");
            ViewBag.trimesterID = new SelectList(db.Trimesters, "trimesterID", "nameTrimester");
            ViewBag.workingDayID = new SelectList(db.WorkingDays, "workingDayID", "initials");
            return View();
        }

        // POST: Schedules/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "scheduleID,startDate,endHDate,startHour,endHour,lunes,martes,miercoles,jueves,viernes,sabado,domingo,headquartesID,EnvironID,groupID,instructorID,version,trimesterID,workingDayID")] Schedule schedule)
        {
            if (ModelState.IsValid)
            {
                db.Schedules.Add(schedule);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.EnvironID = new SelectList(db.Environments, "EnvironID", "numberEnvironment", schedule.EnvironID);
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup", schedule.groupID);
            ViewBag.headquartesID = new SelectList(db.Headquartes, "headquartesID", "nameHeadquartes", schedule.headquartesID);
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber", schedule.instructorID);
            ViewBag.trimesterID = new SelectList(db.Trimesters, "trimesterID", "nameTrimester", schedule.trimesterID);
            ViewBag.workingDayID = new SelectList(db.WorkingDays, "workingDayID", "initials", schedule.workingDayID);
            return View(schedule);
        }

        // GET: Schedules/Edit/5
        [Authorize]
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
            ViewBag.EnvironID = new SelectList(db.Environments, "EnvironID", "numberEnvironment", schedule.EnvironID);
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup", schedule.groupID);
            ViewBag.headquartesID = new SelectList(db.Headquartes, "headquartesID", "nameHeadquartes", schedule.headquartesID);
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber", schedule.instructorID);
            ViewBag.trimesterID = new SelectList(db.Trimesters, "trimesterID", "nameTrimester", schedule.trimesterID);
            ViewBag.workingDayID = new SelectList(db.WorkingDays, "workingDayID", "initials", schedule.workingDayID);
            return View(schedule);
        }

        // POST: Schedules/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "scheduleID,startDate,endHDate,startHour,endHour,lunes,martes,miercoles,jueves,viernes,sabado,domingo,headquartesID,EnvironID,groupID,instructorID,version,trimesterID,workingDayID")] Schedule schedule)
        {
            if (ModelState.IsValid)
            {
                db.Entry(schedule).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.EnvironID = new SelectList(db.Environments, "EnvironID", "numberEnvironment", schedule.EnvironID);
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup", schedule.groupID);
            ViewBag.headquartesID = new SelectList(db.Headquartes, "headquartesID", "nameHeadquartes", schedule.headquartesID);
            ViewBag.instructorID = new SelectList(db.Instructors, "instructorID", "documentNumber", schedule.instructorID);
            ViewBag.trimesterID = new SelectList(db.Trimesters, "trimesterID", "nameTrimester", schedule.trimesterID);
            ViewBag.workingDayID = new SelectList(db.WorkingDays, "workingDayID", "initials", schedule.workingDayID);
            return View(schedule);
        }

        // GET: Schedules/Delete/5
        [Authorize]
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
