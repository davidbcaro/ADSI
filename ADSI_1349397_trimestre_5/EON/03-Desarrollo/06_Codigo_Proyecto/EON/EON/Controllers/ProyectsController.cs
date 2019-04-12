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
    public class ProyectsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Proyects
        public ActionResult Index()
        {
            return View(db.Proyects.ToList());
        }

        // GET: Proyects/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Proyect proyect = db.Proyects.Find(id);
            if (proyect == null)
            {
                return HttpNotFound();
            }
            return View(proyect);
        }

        // GET: Proyects/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Proyects/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Proyect,Code,Name,Status")] Proyect proyect)
        {
            if (ModelState.IsValid)
            {
                db.Proyects.Add(proyect);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(proyect);
        }

        // GET: Proyects/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Proyect proyect = db.Proyects.Find(id);
            if (proyect == null)
            {
                return HttpNotFound();
            }
            return View(proyect);
        }

        // POST: Proyects/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Proyect,Code,Name,Status")] Proyect proyect)
        {
            if (ModelState.IsValid)
            {
                db.Entry(proyect).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(proyect);
        }

        // GET: Proyects/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Proyect proyect = db.Proyects.Find(id);
            if (proyect == null)
            {
                return HttpNotFound();
            }
            return View(proyect);
        }

        // POST: Proyects/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var proyect = db.Proyects.Find(id);
            db.Proyects.Remove(proyect);

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
                return View(proyect);
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
