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
    public class TrainingProgramsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: TrainingPrograms
        public ActionResult Index()
        {
            return View(db.TrainingPrograms.OrderBy(tp=> tp.nameProgram).ToList());
        }

        // GET: TrainingPrograms/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TrainingProgram trainingProgram = db.TrainingPrograms.Find(id);
            if (trainingProgram == null)
            {
                return HttpNotFound();
            }
            return View(trainingProgram);
        }

        // GET: TrainingPrograms/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: TrainingPrograms/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idTrainingProgram,idCode,nameProgram,version,initials,toUpper,toUpper2")] TrainingProgram trainingProgram)
        {
            if (ModelState.IsValid)
            {
                db.TrainingPrograms.Add(trainingProgram);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception e)
                {
                    if (e.InnerException != null &&
                        e.InnerException.InnerException != null &&
                        e.InnerException.InnerException.Message.Contains("Index"))
                    {
                        ModelState.AddModelError(string.Empty, "El campo que intenta crear ya existe.");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, e.Message);
                    }
                    return View(trainingProgram);
                }
                return RedirectToAction("Index");
            }

            return View(trainingProgram);
        }

        // GET: TrainingPrograms/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TrainingProgram trainingProgram = db.TrainingPrograms.Find(id);
            if (trainingProgram == null)
            {
                return HttpNotFound();
            }
            return View(trainingProgram);
        }

        // POST: TrainingPrograms/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idTrainingProgram,idCode,nameProgram,version,initials,toUpper,ToUpper2")] TrainingProgram trainingProgram)
        {
            if (ModelState.IsValid)
            {
                db.Entry(trainingProgram).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(trainingProgram);
        }

        // GET: TrainingPrograms/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TrainingProgram trainingProgram = db.TrainingPrograms.Find(id);
            if (trainingProgram == null)
            {
                return HttpNotFound();
            }
            return View(trainingProgram);
        }

        // POST: TrainingPrograms/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            TrainingProgram trainingProgram = db.TrainingPrograms.Find(id);
            db.TrainingPrograms.Remove(trainingProgram);
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
                return View(trainingProgram);
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
