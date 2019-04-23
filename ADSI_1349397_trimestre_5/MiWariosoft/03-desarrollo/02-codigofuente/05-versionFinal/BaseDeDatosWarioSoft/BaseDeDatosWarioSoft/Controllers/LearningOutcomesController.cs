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
    public class LearningOutcomesController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: LearningOutcomes
        public ActionResult Index()
        {
            var learningOutcomes = db.LearningOutcomes.Include(l => l.Activity);
            return View(learningOutcomes.OrderBy(l => l.Description).ToList());
        }

        // GET: LearningOutcomes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LearningOutcome learningOutcome = db.LearningOutcomes.Find(id);
            if (learningOutcome == null)
            {
                return HttpNotFound();
            }
            return View(learningOutcome);
        }

        // GET: LearningOutcomes/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            ViewBag.IdActivity = new SelectList(db.Activities, "IdActivity", "nameActivity");
            return View();
        }

        // POST: LearningOutcomes/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdLearningOutcome,Description,IdActivity")] LearningOutcome learningOutcome)
        {
            if (ModelState.IsValid)
            {
                db.LearningOutcomes.Add(learningOutcome);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IdActivity = new SelectList(db.Activities, "IdActivity", "nameActivity", learningOutcome.IdActivity);
            return View(learningOutcome);
        }

        // GET: LearningOutcomes/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LearningOutcome learningOutcome = db.LearningOutcomes.Find(id);
            if (learningOutcome == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdActivity = new SelectList(db.Activities, "IdActivity", "nameActivity", learningOutcome.IdActivity);
            return View(learningOutcome);
        }

        // POST: LearningOutcomes/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdLearningOutcome,Description,IdActivity")] LearningOutcome learningOutcome)
        {
            if (ModelState.IsValid)
            {
                db.Entry(learningOutcome).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdActivity = new SelectList(db.Activities, "IdActivity", "nameActivity", learningOutcome.IdActivity);
            return View(learningOutcome);
        }

        // GET: LearningOutcomes/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LearningOutcome learningOutcome = db.LearningOutcomes.Find(id);
            if (learningOutcome == null)
            {
                return HttpNotFound();
            }
            return View(learningOutcome);
        }

        // POST: LearningOutcomes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            LearningOutcome learningOutcome = db.LearningOutcomes.Find(id);
            db.LearningOutcomes.Remove(learningOutcome);
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
