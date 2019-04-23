using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using BaseDeDatosWarioSoft.Models;
using BaseDeDatosWarioSoft.Class;

namespace BaseDeDatosWarioSoft.Controllers
{
    public class UsersController : Controller
    {
        private BaseDeDatosWarioSoftContext db = new BaseDeDatosWarioSoftContext();

        // GET: Users
        public ActionResult Index(string searchString)
        {
            var users = db.Users.Include(u => u.Linkage).Include(u => u.Specialty).Include(u => u.TypeDocument);
            if (!String.IsNullOrEmpty(searchString)) 
            {
                users = users.Where(u => u.FirstName.Contains(searchString)
                                || u.SecondName.Contains(searchString)
                                || u.FirstLastName.Contains(searchString)
                                || u.SecondLastName.Contains(searchString)
                                || u.documentNumber.Contains(searchString)
                                || u.UserName.Contains(searchString)
                                || u.Specialty.Description.Contains(searchString)
                                || u.Linkage.TypeLinkage.Contains(searchString)
                                || u.Email.Contains(searchString)) ;
            }

            return View(users.OrderBy(u => u.FirstName).ToList());
        }

        // GET: Users/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            return View(user);
        }

        // GET: Users/Create
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Create()
        {
            ViewBag.IdLinkage = new SelectList(db.Linkages, "IdLinkage", "TypeLinkage");
            ViewBag.IdSpecialty = new SelectList(db.Specialties, "IdSpecialty", "Description");
            ViewBag.IdTypeDocument = new SelectList(db.TypeDocuments, "IdTypeDocument", "NameTP");
            return View();
        }
    
        // POST: Users/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        
        public ActionResult Create(User user)
        {
            if (ModelState.IsValid)
            {

                var pic = string.Empty;
                var folder = "~/Content/Photos";
                if (user.PhotoFile != null)





                {
                    pic = FilesHelper.UploadPhoto(user.PhotoFile,
                   folder);
                    pic = string.Format("{0}/{1}", folder, pic);
                }
                user.Photo = pic;                
                db.Users.Add(user);
                try
                {
                    db.SaveChanges();
                }
                catch (Exception ex)
                {
                    if (ex.InnerException != null &&
                        ex.InnerException.InnerException != null &&
                        ex.InnerException.InnerException.Message.Contains("Create"))
                    {
                        ModelState.AddModelError(string.Empty, "Hay un registro con el mismo nombre");
                    }
                    else
                    {
                        ModelState.AddModelError(string.Empty, ex.Message);
                    }
                    //return View(User);
                }
                
                return RedirectToAction("Index");
            }

            ViewBag.IdLinkage = new SelectList(db.Linkages, "IdLinkage", "TypeLinkage", user.IdLinkage);
            ViewBag.IdSpecialty = new SelectList(db.Specialties, "IdSpecialty", "Description", user.IdSpecialty);
            ViewBag.IdTypeDocument = new SelectList(db.TypeDocuments, "IdTypeDocument", "NameTP", user.IdTypeDocument);
            return View(user);
        }

        // GET: Users/Edit/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdLinkage = new SelectList(db.Linkages, "IdLinkage", "TypeLinkage", user.IdLinkage);
            ViewBag.IdSpecialty = new SelectList(db.Specialties, "IdSpecialty", "Description", user.IdSpecialty);
            ViewBag.IdTypeDocument = new SelectList(db.TypeDocuments, "IdTypeDocument", "NameTP", user.IdTypeDocument);
            return View(user);
        }

        // POST: Users/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit( User user)
        {
            if (ModelState.IsValid)
            {
                var pic = string.Empty;
                var folder = "~/Content/Photos";
                if (user.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(user.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);
                    user.Photo = pic;
                }
                db.Entry(user).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            
            ViewBag.IdLinkage = new SelectList(db.Linkages, "IdLinkage", "TypeLinkage", user.IdLinkage);
            ViewBag.IdSpecialty = new SelectList(db.Specialties, "IdSpecialty", "Description", user.IdSpecialty);
            ViewBag.IdTypeDocument = new SelectList(db.TypeDocuments, "IdTypeDocument", "NameTP", user.IdTypeDocument);
            return View(user);
        }

        // GET: Users/Delete/5
        [Authorize(Users = "wariosoft1234@gmail.com")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            return View(user);
        }

        // POST: Users/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            User user = db.Users.Find(id);
            db.Users.Remove(user);
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
