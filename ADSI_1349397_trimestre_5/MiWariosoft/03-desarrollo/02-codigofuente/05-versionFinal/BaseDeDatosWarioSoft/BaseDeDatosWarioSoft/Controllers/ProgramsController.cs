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
    public class ProgramsController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Programs
        public ActionResult Index()
        {
            var programs = db.Programs.Include(p => p.trainingLevel);
            return View(programs.ToList());
        }

        // GET: Programs/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Program program = db.Programs.Find(id);
            if (program == null)
            {
                return HttpNotFound();
            }
            return View(program);
        }

        // GET: Programs/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            ViewBag.IdTrainingLevel = new SelectList(db.TrainingLevels, "IdTrainingLevel", "Description");
            return View();
        }

        // POST: Programs/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdProgram,CodeProgram,NameProgram,Description,State,IdTrainingLevel")] Program program)
        {
            if (ModelState.IsValid)
            {
                db.Programs.Add(program);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IdTrainingLevel = new SelectList(db.TrainingLevels, "IdTrainingLevel", "Description", program.IdTrainingLevel);
            return View(program);
        }

        // GET: Programs/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Program program = db.Programs.Find(id);
            if (program == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdTrainingLevel = new SelectList(db.TrainingLevels, "IdTrainingLevel", "Description", program.IdTrainingLevel);
            return View(program);
        }

        // POST: Programs/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdProgram,CodeProgram,NameProgram,Description,State,IdTrainingLevel")] Program program)
        {
            if (ModelState.IsValid)
            {
                db.Entry(program).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdTrainingLevel = new SelectList(db.TrainingLevels, "IdTrainingLevel", "Description", program.IdTrainingLevel);
            return View(program);
        }

        // GET: Programs/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Program program = db.Programs.Find(id);
            if (program == null)
            {
                return HttpNotFound();
            }
            return View(program);
        }

        // POST: Programs/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Program program = db.Programs.Find(id);
            db.Programs.Remove(program);
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
