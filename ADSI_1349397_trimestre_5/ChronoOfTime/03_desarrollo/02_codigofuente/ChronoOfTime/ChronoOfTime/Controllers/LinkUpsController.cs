using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using ChronoOfTime.Models;

namespace ChronoOfTime.Controllers
{
    public class LinkUpsController : Controller
    {
        private DatabaseContext db = new DatabaseContext();

        // GET: LinkUps
        public ActionResult Index()
        {
            return View(db.LinkUps.ToList());
        }

        // GET: LinkUps/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LinkUp linkUp = db.LinkUps.Find(id);
            if (linkUp == null)
            {
                return HttpNotFound();
            }
            return View(linkUp);
        }

        // GET: LinkUps/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: LinkUps/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IDLinkUp,typeLink,Hours,state")] LinkUp linkUp)
        {
            if (ModelState.IsValid)
            {
                db.LinkUps.Add(linkUp);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(linkUp);
        }

        // GET: LinkUps/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LinkUp linkUp = db.LinkUps.Find(id);
            if (linkUp == null)
            {
                return HttpNotFound();
            }
            return View(linkUp);
        }

        // POST: LinkUps/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IDLinkUp,typeLink,Hours,state")] LinkUp linkUp)
        {
            if (ModelState.IsValid)
            {
                db.Entry(linkUp).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(linkUp);
        }

        // GET: LinkUps/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LinkUp linkUp = db.LinkUps.Find(id);
            if (linkUp == null)
            {
                return HttpNotFound();
            }
            return View(linkUp);
        }

        // POST: LinkUps/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            LinkUp linkUp = db.LinkUps.Find(id);
            db.LinkUps.Remove(linkUp);
            db.SaveChanges();
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
