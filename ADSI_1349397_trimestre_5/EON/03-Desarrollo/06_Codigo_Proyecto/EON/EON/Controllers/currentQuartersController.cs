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
    public class currentQuartersController : Controller
    {
        private EonContext db = new EonContext();

        // GET: currentQuarters
        public ActionResult Index()
        {
            var currentQuarters = db.currentQuarters;
            return View(currentQuarters.OrderBy(c => c.idcurrent_Quarter).ToList());
        }

        // GET: currentQuarters/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            currentQuarter currentQuarter = db.currentQuarters.Find(id);
            if (currentQuarter == null)
            {
                return HttpNotFound();
            }
            return View(currentQuarter);
        }

        // GET: currentQuarters/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: currentQuarters/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_current_Quarter,idcurrent_Quarter,start_Date,end_Date")] currentQuarter currentQuarter)
        {
            if (ModelState.IsValid)
            {
                db.currentQuarters.Add(currentQuarter);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(currentQuarter);
        }

        // GET: currentQuarters/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            currentQuarter currentQuarter = db.currentQuarters.Find(id);
            if (currentQuarter == null)
            {
                return HttpNotFound();
            }
            return View(currentQuarter);
        }

        // POST: currentQuarters/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_current_Quarter,idcurrent_Quarter,start_Date,end_Date")] currentQuarter currentQuarter)
        {
            if (ModelState.IsValid)
            {
                db.Entry(currentQuarter).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(currentQuarter);
        }

        // GET: currentQuarters/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            currentQuarter currentQuarter = db.currentQuarters.Find(id);
            if (currentQuarter == null)
            {
                return HttpNotFound();
            }
            return View(currentQuarter);
        }

        // POST: currentQuarters/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var currentQuarter = db.currentQuarters.Find(id);
            db.currentQuarters.Remove(currentQuarter);

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
                return View(currentQuarter);
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
