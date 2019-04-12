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
    public class PhasesController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Phases
        public ActionResult Index()
        {
            var phases = db.Phases.Include(p => p.proyect);
            return View(phases.ToList());
        }

        // GET: Phases/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Phase phase = db.Phases.Find(id);
            if (phase == null)
            {
                return HttpNotFound();
            }
            return View(phase);
        }

        // GET: Phases/Create
        public ActionResult Create()
        {
            ViewBag.id_Proyect = new SelectList(db.Proyects, "id_Proyect", "Code");
            return View();
        }

        // POST: Phases/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Phase,name_Phase,Status,id_Proyect")] Phase phase)
        {
            if (ModelState.IsValid)
            {
                db.Phases.Add(phase);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Proyect = new SelectList(db.Proyects, "id_Proyect", "Code", phase.id_Proyect);
            return View(phase);
        }

        // GET: Phases/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Phase phase = db.Phases.Find(id);
            if (phase == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_Proyect = new SelectList(db.Proyects, "id_Proyect", "Code", phase.id_Proyect);
            return View(phase);
        }

        // POST: Phases/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Phase,name_Phase,Status,id_Proyect")] Phase phase)
        {
            if (ModelState.IsValid)
            {
                db.Entry(phase).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Proyect = new SelectList(db.Proyects, "id_Proyect", "Code", phase.id_Proyect);
            return View(phase);
        }

        // GET: Phases/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Phase phase = db.Phases.Find(id);
            if (phase == null)
            {
                return HttpNotFound();
            }
            return View(phase);
        }

        // POST: Phases/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var phase = db.Phases.Find(id);
            db.Phases.Remove(phase);

            try
            {
                db.SaveChanges();
            }
            catch (Exception ex)
            {
                if(ex.InnerException != null && ex.InnerException.InnerException != null &&
                    ex.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "the register not can't delete because have relations active");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, ex.Message);
                }
                return View(phase);
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
