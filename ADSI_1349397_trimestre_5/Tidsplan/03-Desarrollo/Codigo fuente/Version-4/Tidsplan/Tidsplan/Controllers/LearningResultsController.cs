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
    public class LearningResultsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: LearningResults
        public ActionResult Index()
        {
            return View(db.LearningResults.OrderBy(l=> l.idCode).ToList());
        }

        // GET: LearningResults/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LearningResult learningResult = db.LearningResults.Find(id);
            if (learningResult == null)
            {
                return HttpNotFound();
            }
            return View(learningResult);
        }

        // GET: LearningResults/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: LearningResults/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idLearningResults,idCode,description,toUpper")] LearningResult learningResult)
        {
            if (ModelState.IsValid)
            {
                db.LearningResults.Add(learningResult);
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
                    return View(learningResult);
                }
                return RedirectToAction("Index");
            }

            return View(learningResult);
        }

        // GET: LearningResults/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LearningResult learningResult = db.LearningResults.Find(id);
            if (learningResult == null)
            {
                return HttpNotFound();
            }
            return View(learningResult);
        }

        // POST: LearningResults/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idLearningResults,idCode,description,toUpper")] LearningResult learningResult)
        {
            if (ModelState.IsValid)
            {
                db.Entry(learningResult).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(learningResult);
        }

        // GET: LearningResults/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LearningResult learningResult = db.LearningResults.Find(id);
            if (learningResult == null)
            {
                return HttpNotFound();
            }
            return View(learningResult);
        }

        // POST: LearningResults/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            LearningResult learningResult = db.LearningResults.Find(id);
            db.LearningResults.Remove(learningResult);
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
                return View(learningResult);
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
