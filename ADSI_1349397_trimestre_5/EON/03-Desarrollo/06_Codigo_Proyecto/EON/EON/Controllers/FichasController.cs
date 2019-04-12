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
    public class FichasController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Fichas
        public ActionResult Index()
        {
            var fichas = db.Fichas.Include(f => f.StatusFicha);
            return View(db.Fichas.OrderBy(f => f.number_Ficha).ToList());
        }

        // GET: Fichas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ficha ficha = db.Fichas.Find(id);
            if (ficha == null)
            {
                return HttpNotFound();
            }
            return View(ficha);
        }

        // GET: Fichas/Create
        public ActionResult Create()
        {
            ViewBag.id_Status_Ficha = new SelectList(db.StatusFichas, "id_Status_Ficha", "name_State");
            return View();
        }

        // POST: Fichas/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Ficha,number_Ficha,start_Date,end_Date,Route,id_Status_Ficha")] Ficha ficha)
        {
            if (ModelState.IsValid)
            {
                db.Fichas.Add(ficha);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Status_Ficha = new SelectList(db.StatusFichas, "id_Status_Ficha", "name_State", ficha.id_Status_Ficha);
            return View(ficha);
        }

        // GET: Fichas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ficha ficha = db.Fichas.Find(id);
            if (ficha == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_Status_Ficha = new SelectList(db.StatusFichas, "id_Status_Ficha", "name_State", ficha.id_Status_Ficha);
            return View(ficha);
        }

        // POST: Fichas/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Ficha,number_Ficha,start_Date,end_Date,Route,id_Status_Ficha")] Ficha ficha)
        {
            if (ModelState.IsValid)
            {
                db.Entry(ficha).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Status_Ficha = new SelectList(db.StatusFichas, "id_Status_Ficha", "name_State", ficha.id_Status_Ficha);
            return View(ficha);
        }

        // GET: Fichas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ficha ficha = db.Fichas.Find(id);
            if (ficha == null)
            {
                return HttpNotFound();
            }
            return View(ficha);
        }

        // POST: Fichas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var ficha = db.Fichas.Find(id);
            db.Fichas.Remove(ficha);

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
                return View(ficha);
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
