using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Tidsplan.Class;
using Tidsplan.Models;

namespace Tidsplan.Controllers
{
    public class InstructorsController : Controller
    {
        private TidsplanContext db = new TidsplanContext();

        // GET: Instructors
        public ActionResult Index(String searchString)
        {
            var instructors = db.Instructors.Include(i => i.document).Include(i => i.employment).Include(i => i.speciality);
            
            if (!String.IsNullOrEmpty(searchString))
            {
                instructors = instructors.Where(i => i.firstName.Contains(searchString)
                                               || i.secondName.Contains(searchString)
                                               || i.surname.Contains(searchString)
                                               || i.secondSurname.Contains(searchString)
                                               || i.documentNumber.Contains(searchString)
                                               || i.document.idDocument.Contains(searchString)
                                               || i.speciality.nameSpeciality.Contains(searchString)
                                               || i.employment.typeEmploymentRelationship.Contains(searchString)
                                               || i.email.Contains(searchString));

            }
            return View(instructors.OrderBy(i => i.firstName).ToList());
           
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
        [Authorize]
        public ActionResult Create()

        {
            ViewBag.documentID = new SelectList(db.Documents, "documentID", "idDocument");
            ViewBag.idEmploymentRelationship = new SelectList(db.EmploymentRelationships, "idEmploymentRelationship", "typeEmploymentRelationship");
            ViewBag.idSpeciality = new SelectList(db.Specialities, "idSpeciality", "nameSpeciality");

            return View();
        }

        // POST: Instructors/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Instructor instructor)
        {

            if (ModelState.IsValid)
            {
                var pic = string.Empty; var folder = "~/Content/Photos";
                if (instructor.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(instructor.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);
                }
                instructor.photo = pic; db.Instructors.Add(instructor);
            }
            if (ModelState.IsValid)
            {
                db.Instructors.Add(instructor);
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
                        ModelState.AddModelError(string.Empty, "El campo que intenta crear ya existe");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, ex.Message);
                    }
                   

                }
                return RedirectToAction("Index");

            }

            ViewBag.documentID = new SelectList(db.Documents, "documentID", "idDocument", instructor.documentID);
            ViewBag.idEmploymentRelationship = new SelectList(db.EmploymentRelationships, "idEmploymentRelationship", "typeEmploymentRelationship", instructor.idEmploymentRelationship);
            ViewBag.idSpeciality = new SelectList(db.Specialities, "idSpeciality", "nameSpeciality", instructor.idSpeciality);
            return View(instructor);
        
    }


        // GET: Instructors/Edit/5
        [Authorize]
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
            ViewBag.documentID = new SelectList(db.Documents, "documentID", "idDocument", instructor.documentID);
            ViewBag.idEmploymentRelationship = new SelectList(db.EmploymentRelationships, "idEmploymentRelationship", "typeEmploymentRelationship", instructor.idEmploymentRelationship);
            ViewBag.idSpeciality = new SelectList(db.Specialities, "idSpeciality", "nameSpeciality", instructor.idSpeciality);
            return View(instructor);
        }

        // POST: Instructors/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Instructor instructor)
        {
            if (ModelState.IsValid)
            {
                var pic = string.Empty;
                var folder = "~/Content/Photos";
                if (instructor.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(instructor.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);
                    instructor.photo = pic;
                }
                db.Entry(instructor).State = EntityState.Modified; db.SaveChanges();
                return RedirectToAction("Index");
            }

            if (ModelState.IsValid)
            {
                db.Entry(instructor).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.documentID = new SelectList(db.Documents, "documentID", "idDocument", instructor.documentID);
            ViewBag.idEmploymentRelationship = new SelectList(db.EmploymentRelationships, "idEmploymentRelationship", "typeEmploymentRelationship", instructor.idEmploymentRelationship);
            ViewBag.idSpeciality = new SelectList(db.Specialities, "idSpeciality", "nameSpeciality", instructor.idSpeciality);
            return View(instructor);
        }


        // GET: Instructors/Delete/5
        [Authorize]
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
                return View(instructor);
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
