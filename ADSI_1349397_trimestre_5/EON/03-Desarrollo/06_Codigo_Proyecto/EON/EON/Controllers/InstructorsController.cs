using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using EON.Models;
using EON.Class;

namespace EON.Controllers
{
    public class InstructorsController : Controller
    {
        private EonContext db = new EonContext();

        // GET: Instructors
        public ActionResult Index(string sortOrder, string SearchString )
        {
            var instructors = db.Instructors.Include(i => i.Bonding).Include(i => i.DocumentType).Include(i => i.Speciality);
          


            if (!String.IsNullOrEmpty(SearchString))
            {

                instructors = instructors.Where(i => i.Names.Contains(SearchString)|| i.numberDocument.Contains(SearchString)
                 
                || i.lastNames.Contains(SearchString)
                || i.Speciality.speciality_Name.Contains(SearchString));
            }

         

            return View(instructors.OrderBy(a => a.Names).ToList());



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
            ViewBag.id_Bonding = new SelectList(db.Bondings, "id_Bonding", "Type_Linkage");
            ViewBag.id_Document = new SelectList(db.Documents, "id_Document", "typeDocument");
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name");
          
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
                var pic = string.Empty;
                var folder = "~/Content/Photos";

                if (instructor.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(instructor.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);

                }
                instructor.image = pic;
                db.Instructors.Add(instructor);

                
                db.Instructors.Add(instructor);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_Bonding = new SelectList(db.Bondings, "id_Bonding", "Type_Linkage", instructor.id_Bonding);
            ViewBag.id_Document = new SelectList(db.Documents, "id_Document", "typeDocument", instructor.id_Document);
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name", instructor.id_Speciality);
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
            ViewBag.id_Bonding = new SelectList(db.Bondings, "id_Bonding", "Type_Linkage", instructor.id_Bonding);
            ViewBag.id_Document = new SelectList(db.Documents, "id_Document", "typeDocument", instructor.id_Document);
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name", instructor.id_Speciality);
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
                var pic = string.Empty;
                var folder = "~/Content/Photos";
                if (instructor.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(instructor.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);
                    instructor.image = pic;
                }


                db.Entry(instructor).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_Bonding = new SelectList(db.Bondings, "id_Bonding", "Type_Linkage", instructor.id_Bonding);
            ViewBag.id_Document = new SelectList(db.Documents, "id_Document", "typeDocument", instructor.id_Document);
            ViewBag.id_Speciality = new SelectList(db.Specialities, "id_Speciality", "speciality_Name", instructor.id_Speciality);
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
