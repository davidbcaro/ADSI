using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using BaseDeDatosWarioSoft.Models;

namespace BaseDeDatosWarioSoft.Controllers
{
    public class GroupsController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Groups
        public ActionResult Index(string searchString)
        {
            var groups = db.Groups.Include(g => g.Competition).Include(g => g.Program).Include(g => g.Project).Include(g => g.Trimester).Include(g => g.Version).Include(g => g.WorkingDay);
            if (!String.IsNullOrEmpty(searchString))
            {
                groups = groups.Where(g => g.NumberGroup.Contains(searchString));

            }
            return View(groups.OrderBy(g => g.NumberGroup).ToList());
        }

        // GET: Groups/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Group group = db.Groups.Find(id);
            if (group == null)
            {
                return HttpNotFound();
            }
            return View(group);
        }

        // GET: Groups/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            ViewBag.IdCompetition = new SelectList(db.Competitions, "IdCompetition", "CodeCompetition");
            ViewBag.IdProgram = new SelectList(db.Programs, "IdProgram", "CodeProgram");
            ViewBag.IdProject = new SelectList(db.Projects, "IdProject", "CodeProject");
            ViewBag.IdTrimester = new SelectList(db.Trimesters, "IdTrimester", "Description");
            ViewBag.IdVersion = new SelectList(db.Versions, "IdVersion", "NameVersion");
            ViewBag.IdWorkingDay = new SelectList(db.WorkingDays, "IdWorkingDay", "desciption");
            return View();
        }

        // POST: Groups/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdGroup,NumberGroup,InitialDate,EndDate,IdTrimester,IdProject,IdCompetition,IdVersion,IdProgram,IdWorkingDay")] Group group)
        {
            if (ModelState.IsValid)
            {
                db.Groups.Add(group);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception ex)
                {
                    if (ex.InnerException != null &&
                        ex.InnerException.InnerException != null &&
                        ex.InnerException.InnerException.Message.Contains("Index"))
                    {
                        ModelState.AddModelError(string.Empty, "Hay un registro con el mismo nombre");
                    }
                    
                }

                return RedirectToAction("Index");
            }

            ViewBag.IdCompetition = new SelectList(db.Competitions, "IdCompetition", "CodeCompetition", group.IdCompetition);
            ViewBag.IdProgram = new SelectList(db.Programs, "IdProgram", "CodeProgram", group.IdProgram);
            ViewBag.IdProject = new SelectList(db.Projects, "IdProject", "CodeProject", group.IdProject);
            ViewBag.IdTrimester = new SelectList(db.Trimesters, "IdTrimester", "Description", group.IdTrimester);
            ViewBag.IdVersion = new SelectList(db.Versions, "IdVersion", "NameVersion", group.IdVersion);
            ViewBag.IdWorkingDay = new SelectList(db.WorkingDays, "IdWorkingDay", "desciption", group.IdWorkingDay);
            return View(group);
        }

        // GET: Groups/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Group group = db.Groups.Find(id);
            if (group == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdCompetition = new SelectList(db.Competitions, "IdCompetition", "CodeCompetition", group.IdCompetition);
            ViewBag.IdProgram = new SelectList(db.Programs, "IdProgram", "CodeProgram", group.IdProgram);
            ViewBag.IdProject = new SelectList(db.Projects, "IdProject", "CodeProject", group.IdProject);
            ViewBag.IdTrimester = new SelectList(db.Trimesters, "IdTrimester", "Description", group.IdTrimester);
            ViewBag.IdVersion = new SelectList(db.Versions, "IdVersion", "NameVersion", group.IdVersion);
            ViewBag.IdWorkingDay = new SelectList(db.WorkingDays, "IdWorkingDay", "desciption", group.IdWorkingDay);
            return View(group);
        }

        // POST: Groups/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdGroup,NumberGroup,InitialDate,EndDate,IdTrimester,IdProject,IdCompetition,IdVersion,IdProgram,IdWorkingDay")] Group group)
        {
            if (ModelState.IsValid)
            {
                db.Entry(group).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdCompetition = new SelectList(db.Competitions, "IdCompetition", "CodeCompetition", group.IdCompetition);
            ViewBag.IdProgram = new SelectList(db.Programs, "IdProgram", "CodeProgram", group.IdProgram);
            ViewBag.IdProject = new SelectList(db.Projects, "IdProject", "CodeProject", group.IdProject);
            ViewBag.IdTrimester = new SelectList(db.Trimesters, "IdTrimester", "Description", group.IdTrimester);
            ViewBag.IdVersion = new SelectList(db.Versions, "IdVersion", "NameVersion", group.IdVersion);
            ViewBag.IdWorkingDay = new SelectList(db.WorkingDays, "IdWorkingDay", "desciption", group.IdWorkingDay);
            return View(group);
        }

        // GET: Groups/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Group group = db.Groups.Find(id);
            if (group == null)
            {
                return HttpNotFound();
            }
            return View(group);
        }

        // POST: Groups/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var group = db.Groups.Find(id);
            db.Groups.Remove(group);

            try
            {
                db.SaveChanges();

            }
            catch (Exception ex)
            {
                if (ex.InnerException != null &&
                    ex.InnerException.InnerException != null &&
                    ex.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "El registro no puede eliminarse porque tiene una relación");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, ex.Message);
                }
                return View(group);
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
