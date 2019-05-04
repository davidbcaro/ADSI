using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class TidsplanContext : DbContext
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
    {
        public TidsplanContext() : base("DefaultConnection")

        {

        }
        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
        }

        public System.Data.Entity.DbSet<Tidsplan.Models.Document> Documents { get; set; }



        public System.Data.Entity.DbSet<Tidsplan.Models.Speciality> Specialities { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Instructor> Instructors { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.EmploymentRelationship> EmploymentRelationships { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<OneToManyCascadeDeleteConvention>();
        }

        public System.Data.Entity.DbSet<Tidsplan.Models.Trimester> Trimesters { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.StateGroup> StateGroups { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Group> Groups { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Environmentt> Environments { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Headquartes> Headquartes { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Schedule> Schedules { get; set; }


        public System.Data.Entity.DbSet<Tidsplan.Models.WorkingDay> WorkingDays { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Disponibility> Disponibilities { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Activity> Activities { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Competition> Competitions { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.FormationLevel> FormationLevels { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.LearningResult> LearningResults { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.Project> Projects { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.ProjectPhase> ProjectPhases { get; set; }

        public System.Data.Entity.DbSet<Tidsplan.Models.TrainingProgram> TrainingPrograms { get; set; }
    }
}
