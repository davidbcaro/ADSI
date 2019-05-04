using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Tidsplan.Models;

namespace Tidsplan.Controllers
{
    public class HeadquartesController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Headquartes
        public ActionResult Index()
        {
            return View(db.Headquartes.OrderBy(h=> h.nameHeadquartes).ToList());
        }

        // GET: Headquartes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Headquartes headquartes = db.Headquartes.Find(id);
            if (headquartes == null)
            {
                return HttpNotFound();
            }
            return View(headquartes);
        }

        // GET: Headquartes/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Headquartes/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "headquartesID,nameHeadquartes,address,toUpper,toUpper2")] Headquartes headquartes)
        {
            if (ModelState.IsValid)
            {
                db.Headquartes.Add(headquartes);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception e)
                {
                    if (e.InnerException != null &&
                        e.InnerException.InnerException != null &&
                        e.InnerException.InnerException.Message.Contains("Index"))
                    {
                        ModelState.AddModelError(string.Empty, "El campo que intenta crear ya existe.");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, e.Message);
                    }
                    return View(headquartes);
                }
                return RedirectToAction("Index");
            }

            return View(headquartes);
        }
        // GET: Headquartes/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Headquartes headquartes = db.Headquartes.Find(id);
            if (headquartes == null)
            {
                return HttpNotFound();
            }
            return View(headquartes);
        }

        // POST: Headquartes/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "headquartesID,nameHeadquartes,address,toUpper,toUpper2")] Headquartes headquartes)
        {
            if (ModelState.IsValid)
            {
                db.Entry(headquartes).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(headquartes);
        }

        // GET: Headquartes/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Headquartes headquartes = db.Headquartes.Find(id);
            if (headquartes == null)
            {
                return HttpNotFound();
            }
            return View(headquartes);
        }

        // POST: Headquartes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Headquartes headquartes = db.Headquartes.Find(id);
            db.Headquartes.Remove(headquartes);
            try
            {
                db.SaveChanges();
            }
            catch (Exception e)
            {
                if (e.InnerException != null &&
                    e.InnerException.InnerException != null &&
                    e.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "El campo que intenta borrar ya está vinculado en otro registro.");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, e.Message);
                }
                return View(headquartes);
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
