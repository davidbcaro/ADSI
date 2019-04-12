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
    public class BondingsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Bondings
        public ActionResult Index()
        {
           
            return View(db.Bondings.OrderBy(b => b.hour_Start).ToList());
        }

        // GET: Bondings/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Bonding bonding = db.Bondings.Find(id);
            if (bonding == null)
            {
                return HttpNotFound();
            }
            return View(bonding);
        }

        // GET: Bondings/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Bondings/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Bonding,Type_Linkage,hour_Start,hours_End,Status")] Bonding bonding)
        {
            if (ModelState.IsValid)
            {
                db.Bondings.Add(bonding);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(bonding);
        }

        // GET: Bondings/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Bonding bonding = db.Bondings.Find(id);
            if (bonding == null)
            {
                return HttpNotFound();
            }
            return View(bonding);
        }

        // POST: Bondings/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Bonding,Type_Linkage,hour_Start,hours_End,Status")] Bonding bonding)
        {
            if (ModelState.IsValid)
            {
                db.Entry(bonding).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(bonding);
        }

        // GET: Bondings/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Bonding bonding = db.Bondings.Find(id);
            if (bonding == null)
            {
                return HttpNotFound();
            }
            return View(bonding);
        }

        // POST: Bondings/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
             var bonding = db.Bondings.Find(id);
            db.Bondings.Remove(bonding);

            try
            { 
            db.SaveChanges();
          
            }
            catch (Exception ex)
            {
                if (ex.InnerException != null && ex.InnerException.InnerException != null && ex.InnerException.InnerException.Message.Contains("REFERENCES"))
                {  

                    ModelState.AddModelError(string.Empty, "the register not can't delete because have relations active");
                
            }else{
                    ModelState.AddModelError(string.Empty, ex.Message);
                }

                return View(bonding);
           
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
