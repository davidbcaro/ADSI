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
    public class TrainingLevelsController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: TrainingLevels
        public ActionResult Index()
        {
            return View(db.TrainingLevels.OrderBy(tr => tr.Description).ToList());
        }

        // GET: TrainingLevels/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TrainingLevel trainingLevel = db.TrainingLevels.Find(id);
            if (trainingLevel == null)
            {
                return HttpNotFound();
            }
            return View(trainingLevel);
        }

        // GET: TrainingLevels/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            return View();
        }

        // POST: TrainingLevels/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdTrainingLevel,Description,State")] TrainingLevel trainingLevel)
        {
            if (ModelState.IsValid)
            {
                db.TrainingLevels.Add(trainingLevel);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception ex)
                {
                    if(ex.InnerException != null &&
                        ex.InnerException.InnerException != null &&
                        ex.InnerException.InnerException.Message.Contains("Index"))
                    {
                        ModelState.AddModelError(string.Empty, "Hay un registro con el mismo nombre");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, ex.Message);
                    }
                    return View(trainingLevel);
                }
                
                return RedirectToAction("Index");
            }

            return View(trainingLevel);
        }

        // GET: TrainingLevels/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TrainingLevel trainingLevel = db.TrainingLevels.Find(id);
            if (trainingLevel == null)
            {
                return HttpNotFound();
            }
            return View(trainingLevel);
        }

        // POST: TrainingLevels/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdTrainingLevel,Description,State")] TrainingLevel trainingLevel)
        {
            if (ModelState.IsValid)
            {
                db.Entry(trainingLevel).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(trainingLevel);
        }

        // GET: TrainingLevels/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TrainingLevel trainingLevel = db.TrainingLevels.Find(id);
            if (trainingLevel == null)
            {
                return HttpNotFound();
            }
            return View(trainingLevel);
        }

        // POST: TrainingLevels/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var traininglevel = db.TrainingLevels.Find(id);
            db.TrainingLevels.Remove(traininglevel);

            try
            {
                db.SaveChanges();

            }
            catch (Exception ex)
            {
                if (ex.InnerException != null &&
                    ex.InnerException.InnerException != null &&
                    ex.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "El registro no puede eliminarse porque tiene una relación");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, ex.Message);
                }
                return View(traininglevel);
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
