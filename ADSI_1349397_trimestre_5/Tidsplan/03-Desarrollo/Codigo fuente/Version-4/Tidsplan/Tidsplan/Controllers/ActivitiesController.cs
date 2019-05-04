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
    public class ActivitiesController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Activities
        public ActionResult Index()
        {
            return View(db.Activities.OrderBy(a=> a.idActivity).ToList());
        }

        // GET: Activities/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Activity activity = db.Activities.Find(id);
            if (activity == null)
            {
                return HttpNotFound();
            }
            return View(activity);
        }
        [Authorize]
        // GET: Activities/Create
        public ActionResult Create()
        {
            return View();
        }


        // POST: Activities/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idActivities,idActivity,name,toUpper")] Activity activity)
        {
                if (ModelState.IsValid)
                {
                    db.Activities.Add(activity);
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
                    return View(activity);
                }
                return RedirectToAction("Index");
            }

            return View(activity);
        }


        // GET: Activities/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Activity activity = db.Activities.Find(id);
            if (activity == null)
            {
                return HttpNotFound();
            }
            return View(activity);
        }

        // POST: Activities/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idActivities,idActivity,name,toUpper")] Activity activity)
        {
            if (ModelState.IsValid)
            {
                db.Entry(activity).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(activity);
        }

        // GET: Activities/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Activity activity = db.Activities.Find(id);
            if (activity == null)
            {
                return HttpNotFound();
            }
            return View(activity);
        }

        // POST: Activities/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Activity activity = db.Activities.Find(id);
            db.Activities.Remove(activity);
            try
            {
                db.SaveChanges();
            }
            catch (Exception e)
            {
                if (e.InnerException != null && 
                    e.InnerException.InnerException != null &&
                    e.InnerException.InnerException.Message.Contains("REFERENCIA"))
                {
                    ModelState.AddModelError(string.Empty, "El campo que intenta borrar ya está vinculado en otro registro.");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, e.Message);
                }
                return View(activity);
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
