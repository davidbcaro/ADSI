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
    public class ModalitiesController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Modalities
        public ActionResult Index()
        {
            return View(db.Modalities.OrderBy(m => m.nameModality).ToList());
        }

        // GET: Modalities/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Modality modality = db.Modalities.Find(id);
            if (modality == null)
            {
                return HttpNotFound();
            }
            return View(modality);
        }

        // GET: Modalities/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Modalities/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdModality,nameModality")] Modality modality)
        {
            if (ModelState.IsValid)
            {
                db.Modalities.Add(modality);
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
                    return View(modality); 
                }
               
                return RedirectToAction("Index");
            }

            return View(modality);
        }

        // GET: Modalities/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Modality modality = db.Modalities.Find(id);
            if (modality == null)
            {
                return HttpNotFound();
            }
            return View(modality);
        }

        // POST: Modalities/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdModality,nameModality")] Modality modality)
        {
            if (ModelState.IsValid)
            {
                db.Entry(modality).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(modality);
        }

        // GET: Modalities/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Modality modality = db.Modalities.Find(id);
            if (modality == null)
            {
                return HttpNotFound();
            }
            return View(modality);
        }

        // POST: Modalities/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var modalities = db.Modalities.Find(id);
            db.Modalities.Remove(modalities);

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
                return View(modalities);
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
