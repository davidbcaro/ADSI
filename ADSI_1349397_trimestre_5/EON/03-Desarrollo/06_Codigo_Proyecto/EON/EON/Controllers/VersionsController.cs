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
    public class VersionsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Versions
        public ActionResult Index()
        {
            var versions = db.Versions.Include(v => v.currentQuarters);
            return View(versions.OrderBy(v=> v.version_Name).ToList());
        }

        // GET: Versions/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Models.Version version = db.Versions.Find(id);
            if (version == null)
            {
                return HttpNotFound();
            }
            return View(version);
        }

        // GET: Versions/Create
        public ActionResult Create()
        {
            ViewBag.id_current_Quarter = new SelectList(db.currentQuarters, "id_current_Quarter", "idcurrent_Quarter");
            return View();
        }

        // POST: Versions/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Version,Active,version_Name,id_current_Quarter")] Models.Version version)
        {
            if (ModelState.IsValid)
            {
                db.Versions.Add(version);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_current_Quarter = new SelectList(db.currentQuarters, "id_current_Quarter", "idcurrent_Quarter", version.id_current_Quarter);
            return View(version);
        }

        // GET: Versions/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Models.Version version = db.Versions.Find(id);
            if (version == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_current_Quarter = new SelectList(db.currentQuarters, "id_current_Quarter", "idcurrent_Quarter", version.id_current_Quarter);
            return View(version);
        }

        // POST: Versions/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Version,Active,version_Name,id_current_Quarter")] Models.Version version)
        {
            if (ModelState.IsValid)
            {
                db.Entry(version).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_current_Quarter = new SelectList(db.currentQuarters, "id_current_Quarter", "idcurrent_Quarter", version.id_current_Quarter);
            return View(version);
        }

        // GET: Versions/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Models.Version version = db.Versions.Find(id);
            if (version == null)
            {
                return HttpNotFound();
            }
            return View(version);
        }

        // POST: Versions/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var version = db.Versions.Find(id);
            db.Versions.Remove(version);

            try
            {
                db.SaveChanges();
            }
            catch (Exception ex)
            {
                if (ex.InnerException != null && ex.InnerException.InnerException != null &&
                    ex.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "the register not can't delete because have relations active");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, ex.Message);
                }
                return View(version);
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
