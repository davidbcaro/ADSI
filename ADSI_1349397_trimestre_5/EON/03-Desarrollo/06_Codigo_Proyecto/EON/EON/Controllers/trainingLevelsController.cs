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
    public class trainingLevelsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: trainingLevels
        public ActionResult Index()
        {
            return View(db.trainingLevels.OrderBy(t => t.training_Level).ToList());
        }

        // GET: trainingLevels/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            trainingLevel trainingLevel = db.trainingLevels.Find(id);
            if (trainingLevel == null)
            {
                return HttpNotFound();
            }
            return View(trainingLevel);
        }

        // GET: trainingLevels/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: trainingLevels/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Training_Level,training_Level,Status")] trainingLevel trainingLevel)
        {
            if (ModelState.IsValid)
            {
                db.trainingLevels.Add(trainingLevel);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(trainingLevel);
        }

        // GET: trainingLevels/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            trainingLevel trainingLevel = db.trainingLevels.Find(id);
            if (trainingLevel == null)
            {
                return HttpNotFound();
            }
            return View(trainingLevel);
        }

        // POST: trainingLevels/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Training_Level,training_Level,Status")] trainingLevel trainingLevel)
        {
            if (ModelState.IsValid)
            {
                db.Entry(trainingLevel).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(trainingLevel);
        }

        // GET: trainingLevels/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            trainingLevel trainingLevel = db.trainingLevels.Find(id);
            if (trainingLevel == null)
            {
                return HttpNotFound();
            }
            return View(trainingLevel);
        }

        // POST: trainingLevels/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            trainingLevel trainingLevel = db.trainingLevels.Find(id);
            db.trainingLevels.Remove(trainingLevel);
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
