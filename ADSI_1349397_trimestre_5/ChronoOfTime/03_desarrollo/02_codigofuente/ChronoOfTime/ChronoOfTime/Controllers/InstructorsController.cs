using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using ChronoOfTime.Class;
using ChronoOfTime.Models;

namespace ChronoOfTime.Controllers
{
    public class InstructorsController : Controller
    {
        private DatabaseContext db = new DatabaseContext();

        // GET: Instructors
        public ActionResult Index()
        {
            var instructors = db.Instructors.Include(i => i.disponibility).Include(i => i.document).Include(i => i.linkup);
            return View(instructors.ToList());
        }

        // GET: Instructors/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Instructor instructor = db.Instructors.Find(id);
            if (instructor == null)
            {
                return HttpNotFound();
            }
            return View(instructor);
        }

        // GET: Instructors/Create
        public ActionResult Create()
        {
            ViewBag.IDDisponibility = new SelectList(db.disponibilities, "IDDisponibility", "typeDis");
            ViewBag.IDDocument = new SelectList(db.documents, "IDDocument", "documento");
            ViewBag.IDLinkUp = new SelectList(db.LinkUps, "IDLinkUp", "typeLink");
            return View();
        }

        // POST: Instructors/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Instructor instructor)
        {
            if (ModelState.IsValid)
            {
                var pic = string.Empty; var folder = "~/Content/Photos";
                if (instructor.PhotoFile != null)
                { pic = FilesHelper.UploadPhoto(instructor.PhotoFile, folder); pic = string.Format("{0}/{1}", folder, pic); }
                instructor.Photo = pic;
                db.Instructors.Add(instructor);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IDDisponibility = new SelectList(db.disponibilities, "IDDisponibility", "typeDis", instructor.IDDisponibility);
            ViewBag.IDDocument = new SelectList(db.documents, "IDDocument", "documento", instructor.IDDocument);
            ViewBag.IDLinkUp = new SelectList(db.LinkUps, "IDLinkUp", "typeLink", instructor.IDLinkUp);
            return View(instructor);
        }

        // GET: Instructors/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Instructor instructor = db.Instructors.Find(id);
            if (instructor == null)
            {
                return HttpNotFound();
            }
            ViewBag.IDDisponibility = new SelectList(db.disponibilities, "IDDisponibility", "typeDis", instructor.IDDisponibility);
            ViewBag.IDDocument = new SelectList(db.documents, "IDDocument", "documento", instructor.IDDocument);
            ViewBag.IDLinkUp = new SelectList(db.LinkUps, "IDLinkUp", "typeLink", instructor.IDLinkUp);
            return View(instructor);
        }

        // POST: Instructors/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Instructor instructor)
        {
            if (ModelState.IsValid)
            {
                var pic = string.Empty; var folder = "~/Content/Photos";
                if (instructor.PhotoFile != null)
                { pic = FilesHelper.UploadPhoto(instructor.PhotoFile, folder); pic = string.Format("{0}/{1}", folder, pic); instructor.Photo = pic; }
                db.Entry(instructor).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IDDisponibility = new SelectList(db.disponibilities, "IDDisponibility", "typeDis", instructor.IDDisponibility);
            ViewBag.IDDocument = new SelectList(db.documents, "IDDocument", "documento", instructor.IDDocument);
            ViewBag.IDLinkUp = new SelectList(db.LinkUps, "IDLinkUp", "typeLink", instructor.IDLinkUp);
            return View(instructor);
        }

        // GET: Instructors/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Instructor instructor = db.Instructors.Find(id);
            if (instructor == null)
            {
                return HttpNotFound();
            }
            return View(instructor);
        }

        // POST: Instructors/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Instructor instructor = db.Instructors.Find(id);
            db.Instructors.Remove(instructor);
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
