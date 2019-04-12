using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class EonContext: DbContext
    {
        public EonContext(): base("DefaultConnection")
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



        public System.Data.Entity.DbSet<EON.Models.Ficha> Fichas { get; set; }

        public System.Data.Entity.DbSet<EON.Models.StatusFicha> StatusFichas { get; set; }

        public System.Data.Entity.DbSet<EON.Models.DocumentType> Documents { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Speciality> Specialities { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Bonding> Bondings { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Instructor> Instructors { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Availability> Availabilities { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Headquarters> Headquarters { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Ambience> Ambiences { get; set; }

        public System.Data.Entity.DbSet<EON.Models.currentQuarter> currentQuarters { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Version> Versions { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Modality> Modalities { get; set; }

        public System.Data.Entity.DbSet<EON.Models.workingDay> workingDays { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Trimester> Trimesters { get; set; }

        public System.Data.Entity.DbSet<EON.Models.trainingLevel> trainingLevels { get; set; }

        public System.Data.Entity.DbSet<EON.Models.programVersion> programVersions { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Program> Programs { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Schedule> Schedules { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Competition> Competitions { get; set; }

        public System.Data.Entity.DbSet<EON.Models.learningResult> learningResults { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Proyect> Proyects { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Phase> Phases { get; set; }

        public System.Data.Entity.DbSet<EON.Models.Activity> Activities { get; set; }

       

                
    }

  
}