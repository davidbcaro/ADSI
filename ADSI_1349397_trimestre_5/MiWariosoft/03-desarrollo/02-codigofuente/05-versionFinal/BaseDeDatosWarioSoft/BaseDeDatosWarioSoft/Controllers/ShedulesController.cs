using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using BaseDeDatosWarioSoft.Models;

namespace BaseDeDatosWarioSoft.Controllers
{
    public class ShedulesController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Shedules
        public ActionResult Index(string searchString)
        {
            var shedules = db.Shedules.Include(s => s.Environment).Include(s => s.Group).Include(s => s.Headquarters).Include(s => s.User);
            if (!String.IsNullOrEmpty(searchString))
            {
                shedules = shedules.Where(s => s.Observaciones.Contains(searchString)
                                || s.User.FirstName.Contains(searchString)
                                || s.Environment.EnviromentNumber.Contains(searchString)
                                || s.Headquarters.NameHeadquarters.Contains(searchString)
                                || s.Group.NumberGroup.Contains(searchString));


            }
            return View(shedules.OrderBy(s => s.Headquarters.NameHeadquarters).ToList());
        }


        // GET: Shedules/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Shedule shedule = db.Shedules.Find(id);
            if (shedule == null)
            {
                return HttpNotFound();
            }
            return View(shedule);
        }

        // GET: Shedules/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            ViewBag.IdEnvironment = new SelectList(db.Environments, "IdEnvironment", "EnviromentNumber");
            ViewBag.IdGroup = new SelectList(db.Groups, "IdGroup", "NumberGroup");
            ViewBag.IdHeadquarters = new SelectList(db.Headquarters, "IdHeadquarters", "NameHeadquarters");
            ViewBag.IdModality = new SelectList(db.Modalities, "IdModality", "nameModality");
            ViewBag.UserID = new SelectList(db.Users, "UserID", "FirstName");
            return View();
        }

        // POST: Shedules/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdShedule,Observaciones,StartHour,endHour,InitialDate,EndDate,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,UserID,IdEnvironment,IdHeadquarters,IdGroup,IdModality")] Shedule shedule)
        {
            if (ModelState.IsValid)
            {
                db.Shedules.Add(shedule);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IdEnvironment = new SelectList(db.Environments, "IdEnvironment", "EnviromentNumber", shedule.IdEnvironment);
            ViewBag.IdGroup = new SelectList(db.Groups, "IdGroup", "NumberGroup", shedule.IdGroup);
            ViewBag.IdHeadquarters = new SelectList(db.Headquarters, "IdHeadquarters", "NameHeadquarters", shedule.IdHeadquarters);
            ViewBag.IdModality = new SelectList(db.Modalities, "IdModality", "nameModality", shedule.IdModality);
            ViewBag.UserID = new SelectList(db.Users, "UserID", "FirstName", shedule.UserID);
            return View(shedule);
        }

        // GET: Shedules/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Shedule shedule = db.Shedules.Find(id);
            if (shedule == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdEnvironment = new SelectList(db.Environments, "IdEnvironment", "EnviromentNumber", shedule.IdEnvironment);
            ViewBag.IdGroup = new SelectList(db.Groups, "IdGroup", "NumberGroup", shedule.IdGroup);
            ViewBag.IdHeadquarters = new SelectList(db.Headquarters, "IdHeadquarters", "NameHeadquarters", shedule.IdHeadquarters);
            ViewBag.IdModality = new SelectList(db.Modalities, "IdModality", "nameModality", shedule.IdModality);
            ViewBag.UserID = new SelectList(db.Users, "UserID", "FirstName", shedule.UserID);
            return View(shedule);
        }

        // POST: Shedules/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdShedule,Observaciones,StartHour,endHour,InitialDate,EndDate,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,UserID,IdEnvironment,IdHeadquarters,IdGroup,IdModality")] Shedule shedule)
        {
            if (ModelState.IsValid)
            {
                db.Entry(shedule).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdEnvironment = new SelectList(db.Environments, "IdEnvironment", "EnviromentNumber", shedule.IdEnvironment);
            ViewBag.IdGroup = new SelectList(db.Groups, "IdGroup", "NumberGroup", shedule.IdGroup);
            ViewBag.IdHeadquarters = new SelectList(db.Headquarters, "IdHeadquarters", "NameHeadquarters", shedule.IdHeadquarters);
            ViewBag.IdModality = new SelectList(db.Modalities, "IdModality", "nameModality", shedule.IdModality);
            ViewBag.UserID = new SelectList(db.Users, "UserID", "FirstName", shedule.UserID);
            return View(shedule);
        }

        // GET: Shedules/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Shedule shedule = db.Shedules.Find(id);
            if (shedule == null)
            {
                return HttpNotFound();
            }
            return View(shedule);
        }

        // POST: Shedules/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Shedule shedule = db.Shedules.Find(id);
            db.Shedules.Remove(shedule);
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
