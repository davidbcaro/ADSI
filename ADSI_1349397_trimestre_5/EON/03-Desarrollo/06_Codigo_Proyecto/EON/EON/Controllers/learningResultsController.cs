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
    public class learningResultsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: learningResults
        public ActionResult Index()
        {
            var learningResults = db.learningResults.Include(l => l.Competition);
            var list = db.Competitions.ToList();
            list = list.OrderBy(co => co.FullCompetition).ToList();
            return View(learningResults.ToList());
        }

        // GET: learningResults/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            learningResult learningResult = db.learningResults.Find(id);
            if (learningResult == null)
            {
                return HttpNotFound();
            }
            var list = db.Competitions.ToList();
            list = list.OrderBy(co => co.FullCompetition).ToList();
            return View(learningResult);
        }

        // GET: learningResults/Create
        public ActionResult Create()
        {
            var list = db.Competitions.ToList();
            list = list.OrderBy(co => co.FullCompetition).ToList();
            ViewBag.id_Competition = new SelectList(db.Competitions, "id_Competition", "FullCompetition");
            return View();
        }

        // POST: learningResults/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_learningResult,Code,Description,id_Competition")] learningResult learningResult)
        {
            if (ModelState.IsValid)
            {
                db.learningResults.Add(learningResult);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Competition = new SelectList(db.Competitions, "id_Competition", "Code", learningResult.id_Competition);
            return View(learningResult);
        }

        // GET: learningResults/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            learningResult learningResult = db.learningResults.Find(id);
            if (learningResult == null)
            {
                return HttpNotFound();
            }
            var list = db.Competitions.ToList();
            list = list.OrderBy(co => co.FullCompetition).ToList();
            ViewBag.id_Competition = new SelectList(db.Competitions, "id_Competition", "FullCompetition");
            return View(learningResult);
        }

        // POST: learningResults/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_learningResult,Code,Description,id_Competition")] learningResult learningResult)
        {
            if (ModelState.IsValid)
            {
                db.Entry(learningResult).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Competition = new SelectList(db.Competitions, "id_Competition", "Code", learningResult.id_Competition);
            return View(learningResult);
        }

        // GET: learningResults/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            learningResult learningResult = db.learningResults.Find(id);
            if (learningResult == null)
            {
                return HttpNotFound();
            }
            var list = db.Competitions.ToList();
            list = list.OrderBy(co => co.FullCompetition).ToList();
            return View(learningResult);
        }

        // POST: learningResults/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            learningResult learningResult = db.learningResults.Find(id);
            db.learningResults.Remove(learningResult);
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
