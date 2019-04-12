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
    public class AmbiencesController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Ambiences
        public ActionResult Index(string sortOrder ,string SearchString)
        {
            var ambiences = db.Ambiences.Include(a => a.Headquarters);
          


            if (!String.IsNullOrEmpty(SearchString))
            {

                ambiences = ambiences.Where(a => a.number_Ambience.Contains(SearchString)
                || a.Headquarters.name_Headquarters.Contains(SearchString));

            }
                    return View(ambiences.ToList());
        }

        // GET: Ambiences/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ambience ambience = db.Ambiences.Find(id);
            if (ambience == null)
            {
                return HttpNotFound();
            }
            return View(ambience);
        }

        // GET: Ambiences/Create
        public ActionResult Create()
        {
            ViewBag.id_Headquarters = new SelectList(db.Headquarters, "id_Headquarters", "name_Headquarters");
            return View();
        }

        // POST: Ambiences/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Ambience,number_Ambience,Description,Status,id_Headquarters")] Ambience ambience)
        {
            if (ModelState.IsValid)
            {
                db.Ambiences.Add(ambience);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Headquarters = new SelectList(db.Headquarters, "id_Headquarters", "name_Headquarters", ambience.id_Headquarters);
            return View(ambience);
        }

        // GET: Ambiences/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ambience ambience = db.Ambiences.Find(id);
            if (ambience == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_Headquarters = new SelectList(db.Headquarters, "id_Headquarters", "name_Headquarters", ambience.id_Headquarters);
            return View(ambience);
        }

        // POST: Ambiences/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_Ambience,number_Ambience,Description,Status,id_Headquarters")] Ambience ambience)
        {
            if (ModelState.IsValid)
            {
                db.Entry(ambience).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Headquarters = new SelectList(db.Headquarters, "id_Headquarters", "name_Headquarters", ambience.id_Headquarters);
            return View(ambience);
        }

        // GET: Ambiences/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ambience ambience = db.Ambiences.Find(id);
            if (ambience == null)
            {
                return HttpNotFound();
            }
            return View(ambience);
        }

        // POST: Ambiences/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var ambience = db.Ambiences.Find(id);
            db.Ambiences.Remove(ambience);

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
                return View(ambience);
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
