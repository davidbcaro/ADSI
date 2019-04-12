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
    public class ProgramsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Programs
        public ActionResult Index()
        {
            var programs = db.Programs.Include(p => p.programVersion).Include(p => p.trainingLevel);
            return View(db.Programs.OrderBy(p => p.Name).ToList());
        }

        // GET: Programs/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Program program = db.Programs.Find(id);
            if (program == null)
            {
                return HttpNotFound();
            }
            return View(program);
        }

        // GET: Programs/Create
        public ActionResult Create()
        {
            ViewBag.id_programVersion = new SelectList(db.programVersions, "id_programVersion", "Version");
            ViewBag.id_Training_Level = new SelectList(db.trainingLevels, "id_Training_Level", "training_Level");
            return View();
        }

        // POST: Programs/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Program,Code,Name,Initials,State,id_Training_Level,id_programVersion")] Program program)
        {
            if (ModelState.IsValid)
            {
                db.Programs.Add(program);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_programVersion = new SelectList(db.programVersions, "id_programVersion", "Version", program.id_programVersion);
            ViewBag.id_Training_Level = new SelectList(db.trainingLevels, "id_Training_Level", "training_Level", program.id_Training_Level);
            return View(program);
        }

        // GET: Programs/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Program program = db.Programs.Find(id);
            if (program == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_programVersion = new SelectList(db.programVersions, "id_programVersion", "Version", program.id_programVersion);
            ViewBag.id_Training_Level = new SelectList(db.trainingLevels, "id_Training_Level", "training_Level", program.id_Training_Level);
            return View(program);
        }

        // POST: Programs/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Program,Code,Name,Initials,State,id_Training_Level,id_programVersion")] Program program)
        {
            if (ModelState.IsValid)
            {
                db.Entry(program).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_programVersion = new SelectList(db.programVersions, "id_programVersion", "Version", program.id_programVersion);
            ViewBag.id_Training_Level = new SelectList(db.trainingLevels, "id_Training_Level", "training_Level", program.id_Training_Level);
            return View(program);
        }

        // GET: Programs/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Program program = db.Programs.Find(id);
            if (program == null)
            {
                return HttpNotFound();
            }
            return View(program);
        }

        // POST: Programs/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Program program = db.Programs.Find(id);
            db.Programs.Remove(program);
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
