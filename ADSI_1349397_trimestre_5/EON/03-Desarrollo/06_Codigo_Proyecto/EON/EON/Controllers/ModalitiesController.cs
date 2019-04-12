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
    public class ModalitiesController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Modalities
        public ActionResult Index()
        {
            return View(db.Modalities.OrderBy(m => m.modality_Name).ToList());
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
        public ActionResult Create()
        {
            return View();
        }

        // POST: Modalities/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Modality,modality_Name,State")] Modality modality)
        {
            if (ModelState.IsValid)
            {
                db.Modalities.Add(modality);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(modality);
        }

        // GET: Modalities/Edit/5
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
        public ActionResult Edit([Bind(Include = "id_Modality,modality_Name,State")] Modality modality)
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
            var modality = db.Modalities.Find(id);
            db.Modalities.Remove(modality);

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
                return View(modality);
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
