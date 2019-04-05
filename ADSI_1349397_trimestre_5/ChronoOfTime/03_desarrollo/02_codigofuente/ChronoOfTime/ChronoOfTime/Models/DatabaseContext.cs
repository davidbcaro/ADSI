using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class DatabaseContext : DbContext
    {
        public DatabaseContext() : base("DefaultConnection")
        {

        }
        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
        }

        public DbSet<Project> projects { get; set; }
        public DbSet<Phase> phases { get; set; }
        public DbSet<Activity> activitys { get; set; }
        public DbSet<Document> documents { get; set; }
        public DbSet<Environmenty>environmentys { get; set; }
        public DbSet<Program> Programs { get; set; }

        public DbSet<Disponibility> disponibilities { get; set; }
        //public DbSet<Rol> rolis


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<OneToManyCascadeDeleteConvention>();

         



        }



        public System.Data.Entity.DbSet<ChronoOfTime.Models.LearningResult> LearningResults { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.NumberGroup> NumberGroups { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.Trimester> Trimesters { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.Competence> Competences { get; set; }


        public System.Data.Entity.DbSet<ChronoOfTime.Models.Dayi> Dayis { get; set; }



        public System.Data.Entity.DbSet<ChronoOfTime.Models.WorkingDay> WorkingDays { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.Edition> Editions { get; set; }

       

     

        public System.Data.Entity.DbSet<ChronoOfTime.Models.Headquarters> Headquarters { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.LearningResultHasActivity> LearningResultHasActivities { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.Instructor> Instructors { get; set; }

        public System.Data.Entity.DbSet<ChronoOfTime.Models.LinkUp> LinkUps { get; set; }
       
    }
}