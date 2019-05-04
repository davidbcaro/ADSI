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
    public class FormationLevelsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: FormationLevels
        public ActionResult Index()
        {
            return View(db.FormationLevels.OrderBy(f=> f.LevelFormation).ToList());
        }

        // GET: FormationLevels/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            FormationLevel formationLevel = db.FormationLevels.Find(id);
            if (formationLevel == null)
            {
                return HttpNotFound();
            }
            return View(formationLevel);
        }

        // GET: FormationLevels/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: FormationLevels/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idFormationLvel,LevelFormation,toUpper")] FormationLevel formationLevel)
        {
            if (ModelState.IsValid)
            {
                db.FormationLevels.Add(formationLevel);
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
                    return View(formationLevel);
                }
                return RedirectToAction("Index");
            }

            return View(formationLevel);
        }

        // GET: FormationLevels/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            FormationLevel formationLevel = db.FormationLevels.Find(id);
            if (formationLevel == null)
            {
                return HttpNotFound();
            }
            return View(formationLevel);
        }

        // POST: FormationLevels/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idFormationLvel,LevelFormation,toUpper")] FormationLevel formationLevel)
        {
            if (ModelState.IsValid)
            {
                db.Entry(formationLevel).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(formationLevel);
        }

        // GET: FormationLevels/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            FormationLevel formationLevel = db.FormationLevels.Find(id);
            if (formationLevel == null)
            {
                return HttpNotFound();
            }
            return View(formationLevel);
        }

        // POST: FormationLevels/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            FormationLevel formationLevel = db.FormationLevels.Find(id);
            db.FormationLevels.Remove(formationLevel);
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
                return View(formationLevel);
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
