using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class BaseDeDatosWarioSoftContext : DbContext
    {
        public BaseDeDatosWarioSoftContext() : base ("DefaultConnection")
        {

        }
        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
        }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<OneToManyCascadeDeleteConvention>();
        }


        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Phases> Phases { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Project> Projects { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.WorkingDay> WorkingDays { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.TrainingLevel> TrainingLevels { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Program> Programs { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.LearningOutcome> LearningOutcomes { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Competition> Competitions { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Version> Versions { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Trimester> Trimesters { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.TypeDocument> TypeDocuments { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Linkage> Linkages { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.User> Users { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Activity> Activities { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Environment> Environments { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Specialty> Specialties { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Headquarters> Headquarters { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Shedule> Shedules { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Group> Groups { get; set; }

        public System.Data.Entity.DbSet<BaseDeDatosWarioSoft.Models.Modality> Modalities { get; set; }

        
    }
}