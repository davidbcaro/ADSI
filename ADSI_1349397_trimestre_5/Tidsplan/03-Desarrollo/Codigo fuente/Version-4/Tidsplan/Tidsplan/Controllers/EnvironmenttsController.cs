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
    public class EnvironmenttsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Environmentts
        public ActionResult Index()
        {
            return View(db.Environments.OrderBy(ev=> ev.numberEnvironment).ToList());
        }

        // GET: Environmentts/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Environmentt environmentt = db.Environments.Find(id);
            if (environmentt == null)
            {
                return HttpNotFound();
            }
            return View(environmentt);
        }

        // GET: Environmentts/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Environmentts/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "EnvironID,numberEnvironment,description,toUpper")] Environmentt environmentt)
        {
            if (ModelState.IsValid)
            {
                db.Environments.Add(environmentt);
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
                    return View(environmentt);
                }
                return RedirectToAction("Index");
            }

            return View(environmentt);
        }

        // GET: Environmentts/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Environmentt environmentt = db.Environments.Find(id);
            if (environmentt == null)
            {
                return HttpNotFound();
            }
            return View(environmentt);
        }

        // POST: Environmentts/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "EnvironID,numberEnvironment,description.toUpper")] Environmentt environmentt)
        {
            if (ModelState.IsValid)
            {
                db.Entry(environmentt).State = EntityState.Modified;
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
                    return View(environmentt);
                }
                return RedirectToAction("Index");
            }

            return View(environmentt);
        }

        // GET: Environmentts/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Environmentt environmentt = db.Environments.Find(id);
            if (environmentt == null)
            {
                return HttpNotFound();
            }
            return View(environmentt);
        }

        // POST: Environmentts/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Environmentt environmentt = db.Environments.Find(id);
            db.Environments.Remove(environmentt);
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
                return View(environmentt);
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
