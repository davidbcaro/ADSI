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
    public class SpecialtiesController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Specialties
        public ActionResult Index()
        {
            return View(db.Specialties.OrderBy(sp=>sp.Description).ToList());
        }

        // GET: Specialties/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Specialty specialty = db.Specialties.Find(id);
            if (specialty == null)
            {
                return HttpNotFound();
            }
            return View(specialty);
        }

        // GET: Specialties/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Specialties/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdSpecialty,Description")] Specialty specialty)
        {
            if (ModelState.IsValid)
            {
                db.Specialties.Add(specialty);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception ex)
                {
                    if (ex.InnerException != null && 
                        ex.InnerException.InnerException != null &&
                        ex.InnerException.InnerException.Message.Contains("Index"))
                    {
                        ModelState.AddModelError(string.Empty, "Hay un registro con el mismo nombre");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, ex.Message);
                    }
                    return View(specialty);
                }
                
                return RedirectToAction("Index");
            }

            return View(specialty);
        }

        // GET: Specialties/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Specialty specialty = db.Specialties.Find(id);
            if (specialty == null)
            {
                return HttpNotFound();
            }
            return View(specialty);
        }

        // POST: Specialties/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdSpecialty,Description")] Specialty specialty)
        {
            if (ModelState.IsValid)
            {
                db.Entry(specialty).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(specialty);
        }

        // GET: Specialties/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Specialty specialty = db.Specialties.Find(id);
            if (specialty == null)
            {
                return HttpNotFound();
            }
            return View(specialty);
        }

        // POST: Specialties/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var specialties = db.Specialties.Find(id);
            db.Specialties.Remove(specialties);

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
                return View(specialties);
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
