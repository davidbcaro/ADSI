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
    public class ProjectPhasesController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: ProjectPhases
        public ActionResult Index()
        {
            return View(db.ProjectPhases.OrderBy(pp=> pp.namePhase).ToList());
        }

        // GET: ProjectPhases/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProjectPhase projectPhase = db.ProjectPhases.Find(id);
            if (projectPhase == null)
            {
                return HttpNotFound();
            }
            return View(projectPhase);
        }

        // GET: ProjectPhases/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: ProjectPhases/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idProjectPhase,namePhase,toUpper")] ProjectPhase projectPhase)
        {
            if (ModelState.IsValid)
            {
                db.ProjectPhases.Add(projectPhase);
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
                    return View(projectPhase);
                }
                return RedirectToAction("Index");
            }

            return View(projectPhase);
        }

        // GET: ProjectPhases/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProjectPhase projectPhase = db.ProjectPhases.Find(id);
            if (projectPhase == null)
            {
                return HttpNotFound();
            }
            return View(projectPhase);
        }

        // POST: ProjectPhases/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idProjectPhase,namePhase,toUpper")] ProjectPhase projectPhase)
        {
            if (ModelState.IsValid)
            {
                db.Entry(projectPhase).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(projectPhase);
        }

        // GET: ProjectPhases/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProjectPhase projectPhase = db.ProjectPhases.Find(id);
            if (projectPhase == null)
            {
                return HttpNotFound();
            }
            return View(projectPhase);
        }

        // POST: ProjectPhases/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ProjectPhase projectPhase = db.ProjectPhases.Find(id);
            db.ProjectPhases.Remove(projectPhase);
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
                return View(projectPhase);
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
