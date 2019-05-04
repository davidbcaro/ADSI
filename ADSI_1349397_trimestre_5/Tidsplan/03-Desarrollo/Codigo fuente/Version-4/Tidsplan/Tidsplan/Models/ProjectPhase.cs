using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class ProjectPhase
    {
        [Key]
        public int idProjectPhase { get; set; }

        [Display(Name = "Nombre de fase")]
        [Required(ErrorMessage = "Es requerido")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("ProjectPhase_namePhase_Index", IsUnique = true)]
        public String namePhase { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de fase")]
        public String toUpper
        {
            get
            {
                if (namePhase != null)
                {
                    namePhase = namePhase.ToUpper();
                }
                else
                {
                    namePhase = "Es requerido.";
                }
                return namePhase;
            }
            set
            {
                if (namePhase != null)
                {
                    namePhase = namePhase.ToUpper();
                }
                else
                {
                    namePhase = "Es requerido.";
                }
                namePhase.ToUpper();
            }
        }

        public virtual ICollection<Trimester> trimesters { get; set; }
    }
}