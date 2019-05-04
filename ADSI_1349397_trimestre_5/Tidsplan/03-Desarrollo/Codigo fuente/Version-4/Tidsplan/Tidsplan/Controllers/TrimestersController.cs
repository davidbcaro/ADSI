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
    public class TrimestersController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Trimesters
        public ActionResult Index(String searchString)
        {
            var trimesters = db.Trimesters.Include(t => t.activities).Include(t => t.competitions).Include(t => t.formationLevels).Include(t => t.groups).Include(t => t.learningResults).Include(t => t.projectPhases).Include(t => t.projects).Include(t => t.trainingPrograms);
            if (!String.IsNullOrEmpty(searchString))
            {
                trimesters = trimesters.Where(t => t.activities.name.Contains(searchString)
                || t.competitions.code.Contains(searchString)
                || t.formationLevels.LevelFormation.Contains(searchString)
                || t.groups.numberGroup.Contains(searchString)
                || t.learningResults.idCode.Contains(searchString)
                || t.projectPhases.namePhase.Contains(searchString)
                || t.projects.code.Contains(searchString)
                || t.trainingPrograms.idCode.Contains(searchString)
                || t.nameTrimester.Contains(searchString));

                
            }
                return View(trimesters.OrderBy(tr=> tr.nameTrimester).ToList());
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
        [Authorize]
        public ActionResult Create()
        {
            ViewBag.idActivities = new SelectList(db.Activities, "idActivities", "idActivity");
            ViewBag.idCompetition = new SelectList(db.Competitions, "idCompetition", "code");
            ViewBag.idFormationLvel = new SelectList(db.FormationLevels, "idFormationLvel", "LevelFormation");
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup");
            ViewBag.idLearningResults = new SelectList(db.LearningResults, "idLearningResults", "idCode");
            ViewBag.idProjectPhase = new SelectList(db.ProjectPhases, "idProjectPhase", "namePhase");
            ViewBag.idProject = new SelectList(db.Projects, "idProject", "code");
            ViewBag.idTrainingProgram = new SelectList(db.TrainingPrograms, "idTrainingProgram", "idCode");
            return View();
        }

        // POST: Trimesters/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "trimesterID,nameTrimester,idTrainingProgram,idProjectPhase,idActivities,idCompetition,idFormationLvel,groupID,idLearningResults,idProject,toUpper")] Trimester trimester)
        {
            if (ModelState.IsValid)
            {
                db.Trimesters.Add(trimester);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.idActivities = new SelectList(db.Activities, "idActivities", "idActivity", trimester.idActivities);
            ViewBag.idCompetition = new SelectList(db.Competitions, "idCompetition", "code", trimester.idCompetition);
            ViewBag.idFormationLvel = new SelectList(db.FormationLevels, "idFormationLvel", "LevelFormation", trimester.idFormationLvel);
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup", trimester.groupID);
            ViewBag.idLearningResults = new SelectList(db.LearningResults, "idLearningResults", "idCode", trimester.idLearningResults);
            ViewBag.idProjectPhase = new SelectList(db.ProjectPhases, "idProjectPhase", "namePhase", trimester.idProjectPhase);
            ViewBag.idProject = new SelectList(db.Projects, "idProject", "code", trimester.idProject);
            ViewBag.idTrainingProgram = new SelectList(db.TrainingPrograms, "idTrainingProgram", "idCode", trimester.idTrainingProgram);
            return View(trimester);
        }

        // GET: Trimesters/Edit/5
        [Authorize]
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
            ViewBag.idActivities = new SelectList(db.Activities, "idActivities", "idActivity", trimester.idActivities);
            ViewBag.idCompetition = new SelectList(db.Competitions, "idCompetition", "code", trimester.idCompetition);
            ViewBag.idFormationLvel = new SelectList(db.FormationLevels, "idFormationLvel", "LevelFormation", trimester.idFormationLvel);
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup", trimester.groupID);
            ViewBag.idLearningResults = new SelectList(db.LearningResults, "idLearningResults", "idCode", trimester.idLearningResults);
            ViewBag.idProjectPhase = new SelectList(db.ProjectPhases, "idProjectPhase", "namePhase", trimester.idProjectPhase);
            ViewBag.idProject = new SelectList(db.Projects, "idProject", "code", trimester.idProject);
            ViewBag.idTrainingProgram = new SelectList(db.TrainingPrograms, "idTrainingProgram", "idCode", trimester.idTrainingProgram);
            return View(trimester);
        }

        // POST: Trimesters/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "trimesterID,nameTrimester,idTrainingProgram,idProjectPhase,idActivities,idCompetition,idFormationLvel,groupID,idLearningResults,idProject,toUpper")] Trimester trimester)
        {
            if (ModelState.IsValid)
            {
                db.Entry(trimester).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.idActivities = new SelectList(db.Activities, "idActivities", "idActivity", trimester.idActivities);
            ViewBag.idCompetition = new SelectList(db.Competitions, "idCompetition", "code", trimester.idCompetition);
            ViewBag.idFormationLvel = new SelectList(db.FormationLevels, "idFormationLvel", "LevelFormation", trimester.idFormationLvel);
            ViewBag.groupID = new SelectList(db.Groups, "groupID", "numberGroup", trimester.groupID);
            ViewBag.idLearningResults = new SelectList(db.LearningResults, "idLearningResults", "idCode", trimester.idLearningResults);
            ViewBag.idProjectPhase = new SelectList(db.ProjectPhases, "idProjectPhase", "namePhase", trimester.idProjectPhase);
            ViewBag.idProject = new SelectList(db.Projects, "idProject", "code", trimester.idProject);
            ViewBag.idTrainingProgram = new SelectList(db.TrainingPrograms, "idTrainingProgram", "idCode", trimester.idTrainingProgram);
            return View(trimester);
        }

        // GET: Trimesters/Delete/5
        [Authorize]
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
            try
            {
                db.SaveChanges();
            }
            catch (Exception e)
            {
                if (e.InnerException != null &&
                    e.InnerException.InnerException != null && 
                    e.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "El campo que intenta borrar ya está vinculado en otro registro.");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, e.Message);
                }
                return View(trimester);
            }
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
