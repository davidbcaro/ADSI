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
    public class CompetitionsController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Competitions
        public ActionResult Index()
        {
            var competitions = db.Competitions.Include(c => c.LearningOutcome).Include(c => c.Phases);
            return View(competitions.ToList());
        }

        // GET: Competitions/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Competition competition = db.Competitions.Find(id);
            if (competition == null)
            {
                return HttpNotFound();
            }
            return View(competition);
        }

        // GET: Competitions/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            ViewBag.IdLearningOutcome = new SelectList(db.LearningOutcomes, "IdLearningOutcome", "Description");
            ViewBag.IdPhase = new SelectList(db.Phases, "IdPhase", "name");
            return View();
        }

        // POST: Competitions/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdCompetition,CodeCompetition,RouteCompetition,Description,IdLearningOutcome,IdPhase")] Competition competition)
        {
            if (ModelState.IsValid)
            {
                db.Competitions.Add(competition);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IdLearningOutcome = new SelectList(db.LearningOutcomes, "IdLearningOutcome", "Description", competition.IdLearningOutcome);
            ViewBag.IdPhase = new SelectList(db.Phases, "IdPhase", "name", competition.IdPhase);
            return View(competition);
        }

        // GET: Competitions/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Competition competition = db.Competitions.Find(id);
            if (competition == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdLearningOutcome = new SelectList(db.LearningOutcomes, "IdLearningOutcome", "Description", competition.IdLearningOutcome);
            ViewBag.IdPhase = new SelectList(db.Phases, "IdPhase", "name", competition.IdPhase);
            return View(competition);
        }

        // POST: Competitions/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdCompetition,CodeCompetition,RouteCompetition,Description,IdLearningOutcome,IdPhase")] Competition competition)
        {
            if (ModelState.IsValid)
            {
                db.Entry(competition).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdLearningOutcome = new SelectList(db.LearningOutcomes, "IdLearningOutcome", "Description", competition.IdLearningOutcome);
            ViewBag.IdPhase = new SelectList(db.Phases, "IdPhase", "name", competition.IdPhase);
            return View(competition);
        }

        // GET: Competitions/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Competition competition = db.Competitions.Find(id);
            if (competition == null)
            {
                return HttpNotFound();
            }
            return View(competition);
        }

        // POST: Competitions/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Competition competition = db.Competitions.Find(id);
            db.Competitions.Remove(competition);
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
