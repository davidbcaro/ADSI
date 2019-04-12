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
    public class HeadquartersController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Headquarters
        public ActionResult Index()
        {
            return View(db.Headquarters.OrderBy(h => h.name_Headquarters).ToList());
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
        public ActionResult Create()
        {
            return View();
        }

        // POST: Headquarters/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_Headquarters,name_Headquarters,Address,State")] Headquarters headquarters)
        {
            if (ModelState.IsValid)
            {
                db.Headquarters.Add(headquarters);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(headquarters);
        }

        // GET: Headquarters/Edit/5
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
        public ActionResult Edit([Bind(Include = "id_Headquarters,name_Headquarters,Address,State")] Headquarters headquarters)
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
                if (ex.InnerException != null && ex.InnerException.InnerException != null &&
                    ex.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "the register not can't delete because have relations active");
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
