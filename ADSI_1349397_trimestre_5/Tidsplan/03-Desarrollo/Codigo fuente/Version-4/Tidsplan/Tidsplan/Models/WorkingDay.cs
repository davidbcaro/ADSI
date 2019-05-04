using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class WorkingDay
    {
        [Key]
        public int workingDayID { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Iniciales de jornada")]
        [StringLength(3, ErrorMessage = "Debe contener mínimo un caracter y máximo tres caracteres", MinimumLength = 1)]
        [Index("WorkingDay_initials_Index", IsUnique = true)]
        public String initials { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Iniciales de jornada")]
        public String toUpper
        {
            get
            {
                if (initials != null)
                {
                    initials = initials.ToUpper();
                }
                else
                {
                    initials = "Es requerido.";
                }
                return initials;
            }
            set
            {
                if (initials != null)
                {
                    initials = initials.ToUpper();
                }
                else
                {
                    initials = "Es requerido.";
                }
                initials.ToUpper();
            }
        }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de jornada")]
        [StringLength(20, ErrorMessage = "Debe tener mínimo dos caracteres, máximo veinte caracteres.", MinimumLength = 2)]
        [Index("ProjectPhase_name_Index", IsUnique = true)]
        public String name { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de jornada")]
        public String toUpper2
        {
            get
            {
                if (name != null)
                {
                    name = name.ToUpper();
                }
                else
                {
                    name = "Es requerido.";
                }
                return name;
            }
            set
            {
                if (name != null)
                {
                    name = name.ToUpper();
                }
                else
                {
                    name = "Es requerido.";
                }
                name.ToUpper();
            }
        }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Descripción")]
        [StringLength(100, ErrorMessage = "Debe tener mínimo dos caracteres, máximo cien caracteres.", MinimumLength = 2)]
        [Index("ProjectPhase_description_Index", IsUnique = true)]
        public String description { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Descripción")]
        public String toUpper3
        {
            get
            {
                if (description != null)
                {
                    description = description.ToUpper();
                }
                else
                {
                    description = "Es requerido.";
                }
                return description;
            }
            set
            {
                if (description != null)
                {
                    description = description.ToUpper();
                }
                else
                {
                    description = "Es requerido.";
                }
                description.ToUpper();
            }
        }

        public virtual ICollection<Schedule> schedule { get; set; }
    }
}