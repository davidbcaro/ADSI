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
    public class StateGroupsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: StateGroups
        public ActionResult Index()
        {
            return View(db.StateGroups.OrderBy(st=> st.nameState).ToList());
        }

        // GET: StateGroups/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            StateGroup stateGroup = db.StateGroups.Find(id);
            if (stateGroup == null)
            {
                return HttpNotFound();
            }
            return View(stateGroup);
        }

        // GET: StateGroups/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: StateGroups/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "stateGroupID,nameState,toUpper")] StateGroup stateGroup)
        {
            if (ModelState.IsValid)
            {
                db.StateGroups.Add(stateGroup);
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
                    return View(stateGroup);
                }
                return RedirectToAction("Index");
            }

            return View(stateGroup);
        }

        // GET: StateGroups/Edit/5
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            StateGroup stateGroup = db.StateGroups.Find(id);
            if (stateGroup == null)
            {
                return HttpNotFound();
            }
            return View(stateGroup);
        }

        // POST: StateGroups/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "stateGroupID,nameState.toUpper")] StateGroup stateGroup)
        {
            if (ModelState.IsValid)
            {
                db.Entry(stateGroup).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(stateGroup);
        }

        // GET: StateGroups/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            StateGroup stateGroup = db.StateGroups.Find(id);
            if (stateGroup == null)
            {
                return HttpNotFound();
            }
            return View(stateGroup);
        }

        // POST: StateGroups/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            StateGroup stateGroup = db.StateGroups.Find(id);
            db.StateGroups.Remove(stateGroup);
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
                return View(stateGroup);
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
