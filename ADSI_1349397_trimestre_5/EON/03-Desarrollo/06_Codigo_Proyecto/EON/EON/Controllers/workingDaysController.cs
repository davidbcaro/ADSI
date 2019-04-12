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
using System.Web.UI.WebControls;

namespace EON.Controllers
{
    public class workingDaysController : Controller
    {
        private EonContext db = new EonContext();

        // GET: workingDays
        public ActionResult Index()
        {
            return View(db.workingDays.OrderBy(w => w.Name).ToList());
        }

        // GET: workingDays/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            workingDay workingDay = db.workingDays.Find(id);
            if (workingDay == null)
            {
                return HttpNotFound();
            }
            return View(workingDay);
        }

        // GET: workingDays/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: workingDays/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(workingDay workingDays)
        {

            if (ModelState.IsValid)
            {

                var pic = string.Empty;
                var folder = "~/Content/Photos";

                if (workingDays.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(workingDays.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);

                }
                workingDays.image = pic;
                db.workingDays.Add(workingDays);


                db.workingDays.Add(workingDays);
                db.SaveChanges();

                return RedirectToAction("Index");
            }


            return View(workingDays);
        }

        // GET: workingDays/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {


                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            workingDay workingDay = db.workingDays.Find(id);
            if (workingDay == null)
            {
                return HttpNotFound();
            }
            return View(workingDay);
        }

        // POST: workingDays/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(workingDay workingDays)
        {
            if (ModelState.IsValid)
            {
                var pic = string.Empty;
                var folder = "~/Content/Photos";
                if (workingDays.PhotoFile != null)
                {
                    pic = FilesHelper.UploadPhoto(workingDays.PhotoFile, folder);
                    pic = string.Format("{0}/{1}", folder, pic);
                    workingDays.image = pic;
                }
                db.Entry(workingDays).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            if (ModelState.IsValid)
            {

            }
            return View(workingDays);
        }

        // GET: workingDays/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            workingDay workingDay = db.workingDays.Find(id);
            if (workingDay == null)
            {
                return HttpNotFound();
            }


            return View(workingDay);


        }

        // POST: workingDays/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var workingDay = db.workingDays.Find(id);
            db.workingDays.Remove(workingDay);

            try
            {
                db.SaveChanges();
            }
            catch (Exception ex)
            {
                if (ex.InnerException != null && ex.InnerException.InnerException != null &&
                    ex.InnerException.InnerException.Message.Contains("REFERENCE"))
                {
                    ModelState.AddModelError(string.Empty, "the register not can't delete because have relations active");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, ex.Message);
                }
                return View(workingDay);
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