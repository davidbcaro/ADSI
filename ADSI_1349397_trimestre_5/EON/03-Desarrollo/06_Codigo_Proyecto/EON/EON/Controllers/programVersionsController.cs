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
    public class programVersionsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: programVersions
        public ActionResult Index()
        {
            return View(db.programVersions.OrderBy(p => p.Programs).ToList());
        }

        // GET: programVersions/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            programVersion programVersion = db.programVersions.Find(id);
            if (programVersion == null)
            {
                return HttpNotFound();
            }
            return View(programVersion);
        }

        // GET: programVersions/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: programVersions/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_programVersion,Version,Status")] programVersion programVersion)
        {
            if (ModelState.IsValid)
            {
                db.programVersions.Add(programVersion);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(programVersion);
        }

        // GET: programVersions/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            programVersion programVersion = db.programVersions.Find(id);
            if (programVersion == null)
            {
                return HttpNotFound();
            }
            return View(programVersion);
        }

        // POST: programVersions/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_programVersion,Version,Status")] programVersion programVersion)
        {
            if (ModelState.IsValid)
            {
                db.Entry(programVersion).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(programVersion);
        }

        // GET: programVersions/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            programVersion programVersion = db.programVersions.Find(id);
            if (programVersion == null)
            {
                return HttpNotFound();
            }
            return View(programVersion);
        }

        // POST: programVersions/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            programVersion programVersion = db.programVersions.Find(id);
            db.programVersions.Remove(programVersion);
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
