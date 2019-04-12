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
    public class CompetitionsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Competitions
        public ActionResult Index()
        {
            var competitions = db.Competitions.Include(c => c.Program);
            var list = db.Programs.ToList();
            list = list.OrderBy(p => p.FullProgram).ToList();
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
            var list = db.Programs.ToList();
            list = list.OrderBy(p => p.FullProgram).ToList();
            return View(competition);
        }

        // GET: Competitions/Create
        public ActionResult Create()
        {
            var list = db.Programs.ToList();
            list = list.OrderBy(p => p.FullProgram).ToList();
            ViewBag.id_Program = new SelectList(db.Programs, "id_Program", "FullProgram");
            return View();
        }

        // POST: Competitions/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Competition,Code,Description,id_Program")] Competition competition)
        {
            if (ModelState.IsValid)
            {
                db.Competitions.Add(competition);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Program = new SelectList(db.Programs, "id_Program", "Code", competition.id_Program);
            return View(competition);
        }

        // GET: Competitions/Edit/5
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
            var list = db.Programs.ToList();
            list = list.OrderBy(p => p.FullProgram).ToList();
            ViewBag.id_Program = new SelectList(db.Programs, "id_Program", "FullProgram");
            return View(competition);
        }

        // POST: Competitions/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Competition,Code,Description,id_Program")] Competition competition)
        {
            if (ModelState.IsValid)
            {
                db.Entry(competition).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Program = new SelectList(db.Programs, "id_Program", "Code", competition.id_Program);
            return View(competition);
        }

        // GET: Competitions/Delete/5
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
            var list = db.Programs.ToList();
            list = list.OrderBy(p => p.FullProgram).ToList();
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
