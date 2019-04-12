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
    public class StatusFichasController : Controller
    {
        private EonContext db = new EonContext();

        // GET: StatusFichas
        public ActionResult Index()
        {
            return View(db.StatusFichas.ToList());
        }

        // GET: StatusFichas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            StatusFicha statusFicha = db.StatusFichas.Find(id);
            if (statusFicha == null)
            {
                return HttpNotFound();
            }
            return View(statusFicha);
        }

        // GET: StatusFichas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: StatusFichas/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Status_Ficha,name_State,Status")] StatusFicha statusFicha)
        {
            if (ModelState.IsValid)
            {
                db.StatusFichas.Add(statusFicha);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(statusFicha);
        }

        // GET: StatusFichas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            StatusFicha statusFicha = db.StatusFichas.Find(id);
            if (statusFicha == null)
            {
                return HttpNotFound();
            }
            return View(statusFicha);
        }

        // POST: StatusFichas/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Status_Ficha,name_State,Status")] StatusFicha statusFicha)
        {
            if (ModelState.IsValid)
            {
                db.Entry(statusFicha).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(statusFicha);
        }

        // GET: StatusFichas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            StatusFicha statusFicha = db.StatusFichas.Find(id);
            if (statusFicha == null)
            {
                return HttpNotFound();
            }
            return View(statusFicha);
        }

        // POST: StatusFichas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            StatusFicha statusFicha = db.StatusFichas.Find(id);
            db.StatusFichas.Remove(statusFicha);

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
                return View(statusFicha);
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
