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
    public class LinkagesController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Linkages
        public ActionResult Index()
        {
            return View(db.Linkages.OrderBy(lin=>lin.TypeLinkage).ToList());
        }

        // GET: Linkages/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Linkage linkage = db.Linkages.Find(id);
            if (linkage == null)
            {
                return HttpNotFound();
            }
            return View(linkage);
        }

        // GET: Linkages/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Linkages/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdLinkage,TypeLinkage,Hours,State")] Linkage linkage)
        {
            if (ModelState.IsValid)
            {
                db.Linkages.Add(linkage);
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
                    return View(linkage);
                }
                
                return RedirectToAction("Index");
            }

            return View(linkage);
        }

        // GET: Linkages/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Linkage linkage = db.Linkages.Find(id);
            if (linkage == null)
            {
                return HttpNotFound();
            }
            return View(linkage);
        }

        // POST: Linkages/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdLinkage,TypeLinkage,Hours,State")] Linkage linkage)
        {
            if (ModelState.IsValid)
            {
                db.Entry(linkage).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(linkage);
        }

        // GET: Linkages/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Linkage linkage = db.Linkages.Find(id);
            if (linkage == null)
            {
                return HttpNotFound();
            }
            return View(linkage);
        }

        // POST: Linkages/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var linkages = db.Linkages.Find(id);
            db.Linkages.Remove(linkages);

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
                return View(linkages);
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
