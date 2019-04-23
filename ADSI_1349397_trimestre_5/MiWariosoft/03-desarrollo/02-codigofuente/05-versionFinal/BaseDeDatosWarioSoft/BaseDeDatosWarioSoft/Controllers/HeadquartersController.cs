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
    public class HeadquartersController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Headquarters
        public ActionResult Index()
        {
            return View(db.Headquarters.OrderBy(h=>h.NameHeadquarters).ToList());
        }

        // GET: Headquarters/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Headquarters headquarters = db.Headquarters.Find(id);
            if (headquarters == null)
            {
                return HttpNotFound();
            }
            return View(headquarters);
        }

        // GET: Headquarters/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Headquarters/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdHeadquarters,NameHeadquarters,Description,State")] Headquarters headquarters)
        {
            if (ModelState.IsValid)
            {
                db.Headquarters.Add(headquarters);
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
                    else {
                        ModelState.AddModelError(string.Empty, ex.Message);
                    }
                    return View(headquarters);
                }
               
                return RedirectToAction("Index");
            }

            return View(headquarters);
        }

        // GET: Headquarters/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Headquarters headquarters = db.Headquarters.Find(id);
            if (headquarters == null)
            {
                return HttpNotFound();
            }
            return View(headquarters);
        }

        // POST: Headquarters/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdHeadquarters,NameHeadquarters,Description,State")] Headquarters headquarters)
        {
            if (ModelState.IsValid)
            {
                db.Entry(headquarters).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(headquarters);
        }

        // GET: Headquarters/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Headquarters headquarters = db.Headquarters.Find(id);
            if (headquarters == null)
            {
                return HttpNotFound();
            }
            return View(headquarters);
        }

        // POST: Headquarters/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var headquarters = db.Headquarters.Find(id);
            db.Headquarters.Remove(headquarters);

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
                return View(headquarters);
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
